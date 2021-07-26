package ultis.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MessageProperties {

	private Properties properties;

	public MessageProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(DatabaseProperties.RESOURCE_FOLDER_URL + "message.properties"));
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}

