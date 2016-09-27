package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;




public class Storage {
	
	public static class StorageOperationException extends Exception {
		public StorageOperationException(String message) {
			super(message);
		}
	}
	
	public abstract String getPath();
	
	public abstract void save(AddressBook addressBook)throws StorageOperationException;
	
    public abstract AddressBook load() throws StorageOperationException;
}
