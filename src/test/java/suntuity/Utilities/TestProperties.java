package suntuity.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public final static String IEBOWSERDRIVER = "IEBOWSERDRIVER";
	public final static String CHROMEDRIVER = "CHROMEDRIVER";
	public final static String PROPERTY_FILENAME = "config/Test.properties";
	public Properties test_properties = new Properties();
	public final static String TESTSETUP = "TESTSETUP";
	public static final String IEBOWSERDRIVER64 = "IEBOWSERDRIVER64";

	public TestProperties() {
		try {
			test_properties.load(new FileInputStream(PROPERTY_FILENAME));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assert !test_properties.isEmpty();
	}

	public String getProperty(final String key) {
		String property = test_properties.getProperty(key);
		return property != null ? property.trim() : property;
	}

}
