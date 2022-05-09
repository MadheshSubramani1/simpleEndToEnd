package utility;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserOptions {

	public ChromeOptions chrome() {

		File path = new File(System.getProperty("user.dir") + File.separator + "DownloadFile");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentSetting = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", path.getAbsolutePath());
		prefs.put("plugins.always_open_pdf_externally", true);
        contentSetting.put("notifications", 2);
		contentSetting.put("geolocation", 2);
		profile.put("managed_default_content_settings", contentSetting);
        prefs.put("profile", profile);
        options.addArguments("--start-maximized");
		options.setExperimentalOption("prefs", prefs);

		return options;
	}

	public FirefoxOptions firefox() {

		File folder = new File(UUID.randomUUID().toString());
		FirefoxOptions options = new FirefoxOptions();

		FirefoxProfile profile = new FirefoxProfile();

		// to stop the save location confirmation window
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");

		// to disable the pdf preview
		profile.setPreference("pdfjs.disabled", true);

		// to download the file in desired location
		profile.setPreference("browser.download.dir", folder.getAbsolutePath());
		profile.setPreference("browser. download. folderList", 2);
		
		profile.setPreference("geo.enabled", true);
		profile.setPreference("geo.prompt.testing", true);
		profile.setPreference("geo.prompt.testing.allow", false);

		options.setProfile(profile);

		return options;
	}

	public EdgeOptions edge() {

		File paths = new File(System.getProperty("user.dir") + File.separator + "DownloadFile");

		EdgeOptions options = new EdgeOptions();

		HashMap<String, Integer> contentSetting = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", paths.getAbsolutePath());
		prefs.put("plugins.always_open_pdf_externally", true);
        contentSetting.put("notifications", 2);
		contentSetting.put("geolocation", 2);
		profile.put("managed_default_content_settings", contentSetting);
        prefs.put("profile", profile);
        options.addArguments("--start-maximized");
		options.setExperimentalOption("prefs", prefs);

		return options;
	}

}
