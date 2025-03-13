package com.example.androidkotlinproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts 
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidkotlinproject.databinding.FirstLayoutBinding
import com.example.androidkotlinproject.ui.theme.AndroidKotlinProjectTheme

class MainActivity : ComponentActivity() {

    private  val TAG:String="MainActivity"

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                //做进一步处理
                val data: Intent? = result.data
                data?.let { data2 ->
                    val result = data2.getStringExtra("data_return")
                    Log.d(TAG, "extra data is {$result}")
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        /*setContent {
            AndroidKotlinProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }*/


        /*setContentView(R.layout.first_layout)
        val button: Button = findViewById(R.id.button1)
        button.setOnClickListener{
            Toast.makeText(this,"You Click Button 1",Toast.LENGTH_SHORT).show()
        }*/

        val binding = FirstLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
            /*val intent=Intent(this,SecondActivity::class.java)*/
            val intent = Intent("com.example.androidkotlinproject.ACTION_START")
            intent.setPackage(this.packageName)
            intent.putExtra("extra_data", "Hello SecondActivity")

            resultLauncher.launch(intent)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You Click Add", Toast.LENGTH_SHORT).show()
            R.id.remoe_item -> Toast.makeText(this, "You Click Remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidKotlinProjectTheme {
        Greeting("Android")
    }
}