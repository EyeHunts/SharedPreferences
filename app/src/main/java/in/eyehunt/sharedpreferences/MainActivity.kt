package `in`.eyehunt.sharedpreferences

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //saving data
    fun saveData(view: View) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("name", et_name.text.toString())
            putInt("number", et_number.text.toString().toInt())
            commit()
        }
    }


    fun getData(view: View) {
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val str_name = sharedPref.getString("name", "")
        val int_number = sharedPref.getInt("number", 0)
        Toast.makeText(this, "$str_name $int_number", Toast.LENGTH_LONG).show()

    }
}
