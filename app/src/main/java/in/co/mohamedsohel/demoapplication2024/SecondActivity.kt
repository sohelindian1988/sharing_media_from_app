package `in`.co.mohamedsohel.demoapplication2024

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import `in`.co.mohamedsohel.demoapplication2024.ui.theme.DemoApplication2024Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val tvUerName=findViewById<TextView>(R.id.tvUerName)
        val bundle = intent.extras
        var userName=""
        if(bundle!= null)
        {
            userName=bundle.getString("uName").toString()
            tvUerName.text =userName

        }
    }
}
