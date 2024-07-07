package com.example.recreate
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recreate.kotlin.Contact
import com.example.recreate.kotlin.ContactAdapter
import com.example.recreate.kotlin.SmsWorker
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val contactViewModel: ContactViewModel by viewModels {
        ContactViewModelFactory((application as BirthdayApp).repository)
    }

    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var birthdayEditText: EditText
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        birthdayEditText = findViewById(R.id.birthdayEditText)
        addButton = findViewById(R.id.addButton)
        recyclerView = findViewById(R.id.recyclerView)

        val adapter = ContactAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        contactViewModel.allContacts.observe(this) { contacts ->
            contacts?.let { adapter.submitList(it) }
        }

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val birthday = birthdayEditText.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty() && birthday.isNotEmpty()) {
                val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(birthday)
                if (date != null) {
                    val contact = Contact(name = name, phoneNumber = phone, birthday = date)
                    contactViewModel.insert(contact)

                    val today = Calendar.getInstance()
                    val birthdayCalendar = Calendar.getInstance()
                    birthdayCalendar.time = date
                    birthdayCalendar.set(Calendar.YEAR, today.get(Calendar.YEAR))

                    if (birthdayCalendar.before(today)) {
                        birthdayCalendar.add(Calendar.YEAR, 1)
                    }

                    val delay = birthdayCalendar.timeInMillis - today.timeInMillis
                    SmsWorker.scheduleSms(applicationContext, phone, "Happy Birthday $name!", delay)
                }
            }
        }
    }
}
