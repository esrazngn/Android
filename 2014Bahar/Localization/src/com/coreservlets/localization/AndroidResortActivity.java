ckage com.coreservlets.localization;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/** Shows a small advertisement for the world-famous Android Resort.
 *  Supports English, Spanish, Mexican Spanish, portrait mode,
 *  landscape mode, low-resolution, medium resolution, and high resolution.
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */

public class AndroidResortActivity extends Activity {
    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void confirmRegistration(View clickedButton) {
        String message = getString(R.string.confirmed);
        showToast(message);
    }
    
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}