package projects.bankaccount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistentBanker extends Banker {
	
	private final boolean saving;
	private File file;

	public PersistentBanker(String name) {
		super(name);
		this.saving = false;
	}
	
	public PersistentBanker(String name, String folder) {
		super(name);
		try {
			this.saving = true;
			
			final File dateFolder = new File(folder);
			dateFolder.mkdir();
			final File file = new File(dateFolder, name);
			if(!file.exists()) file.createNewFile();
			this.file = file;
			
			loadAccounts();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void addAccount(Account account) {
		super.addAccount(account);
		saveAccounts();
	}
	
	public void saveAccounts() {
		try {
			if(saving) {
				final FileWriter writer = new FileWriter(file);
			
				for(Account account : super.accounts)
					writer.write(account.getName() + "=" + account.getBalance() + "\n");

				writer.flush();
				writer.close();
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void loadAccounts() {
		try {
			if(saving) {
				final Scanner scanner = new Scanner(file);
			
				super.accounts.clear();
				while(scanner.hasNextLine()) {
					final String[] parts = scanner.nextLine().split("=");
					super.accounts.add(new Account(parts[0], Double.parseDouble(parts[1])));
				}
			
				scanner.close();
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
 }
