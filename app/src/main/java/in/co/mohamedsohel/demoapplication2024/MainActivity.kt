package `in`.co.mohamedsohel.demoapplication2024

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

import androidx.activity.ComponentActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import java.io.File
import java.io.FileOutputStream

class MainActivity : ComponentActivity() {
    private lateinit var etUserName:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSend =findViewById<Button>(R.id.btnSend)
         etUserName= findViewById(R.id.etUserName)
        val btnOpenWebsite=findViewById<Button>(R.id.btnOpenWebsite)
        val imageView=findViewById<ImageView>(R.id.imageView)
        val buttonShare=findViewById<Button>(R.id.buttonShare)
        btnSend.setOnClickListener {
            val userName = etUserName.text.toString().trim()
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("uName", userName)
            startActivity(i)
        }
        btnOpenWebsite.setOnClickListener {
            val i=Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse("https://mohamedsohel.co.in"))
            startActivity(i)
        }
        buttonShare.setOnClickListener {

           // val bitmap=imageView.drawable.toBitmap()
            val uri:Uri=getSharingImageURI(/*bitmap*/)
            val i=Intent(Intent.ACTION_SEND)
            i.putExtra(Intent.EXTRA_STREAM,uri)
            i.putExtra(Intent.EXTRA_TEXT,"Download")
            i.putExtra(Intent.EXTRA_SUBJECT,"THIS IS SUBJECT")
            i.setType("image/*")
            startActivity(Intent.createChooser(i,"Share via my app"))


        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getSharingImageURI(/*bitmap: Bitmap*/): Uri {
        val folder= File(cacheDir,"")
        folder.mkdirs()
        val file=File(folder,"shared_images.jpg")

        val uri=FileProvider.getUriForFile(this,"`in`.co.mohamedsohel.demoapplication2024",file)

           return uri
    }
}
