package seedu.addressbook.storage;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.storage.jaxb.AdaptedAddressBook;


public class StorageStub extends Storage{
	/*
	 * Default file path used if the user doesn't provide the file name
	 */
	public static final String DEFAULT_STORAGE_FILEPATH = "addressbook.txt";
	
	/*
	 * Signals tat the given file path does not fulfill the storage filepath constraints
	 */
	public static class InvalidStorageFilePathException extends IllegalValueException {
		public InvalidStorageFilePathException(String message){
			super(message);
		}
	}
	
	/*
	 * Signals that some error has occured while trying to convert and read/write data between 
	 * the application and the storage file
	 * 
	 */
	
	private final JAXBContext jaxbContext;
	
	public final Path path;
	
	/*
	 * @throws InvalidStorageFilePathException if the default path is invalid
	 */
	public StorageStub() throws InvalidStorageFilePathException{
		this(DEFAULT_STORAGE_FILEPATH);
	}
	
	/*
	 * @throws InvalidStorageFilePathException if the given file path is invalid
	 */
	public StorageStub(String filePath) throws InvalidStorageFilePathException{
		try {
			jaxbContext = JAXBContext.newInstance(AdaptedAddressBook.class);
		}catch (JAXBException jaxbe) {
			throw new RuntimeException("jaxb initialisation error");
	
		}
		
		path = Paths.get(filePath);
		if (!isValidPath(path)) {
			throw new InvalidStorageFilePathException("Storage file should end with '.txt'");
		}
	}
	
	private static boolean isValidPath(Path filePath){
		return filePath.toString().endsWith(".txt");
	}
	
	@Override
	public String getPath() {
		return "";
	}
	
	@Override
	public AddressBook load() throws StorageOperationException{
		return new AddressBook();
	}
	
	@Override
	public void save(AddressBook addressBook) throws StorageOperationException{
	}
	
}
