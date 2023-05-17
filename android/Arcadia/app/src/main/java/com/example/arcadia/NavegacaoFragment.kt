import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.arcadia.ChatFragment
import com.example.arcadia.ConfigFragment
import com.example.arcadia.HomeFragment
import com.example.arcadia.ListFragment
import com.example.arcadia.R
import com.example.arcadia.databinding.FragmentNavegacaoBinding

class NavegacaoFragment : Fragment() {

    private lateinit var binding: FragmentNavegacaoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNavegacaoBinding.inflate(inflater)
        inflater.inflate(R.layout.fragment_navegacao, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivHome.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.fragment_tela, HomeFragment(), "FRAGMENT_HOME")
            transaction.commit()
        }

        binding.ivHome.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.fragment_tela, ChatFragment(), "FRAGMENT_CHAT")
            transaction.commit()
        }

        binding.ivHome.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.fragment_tela, ListFragment(), "FRAGMENT_LIST")
            transaction.commit()
        }

        binding.ivHome.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction!!.replace(R.id.fragment_tela, ConfigFragment(), "FRAGMENT_CONFIG")
            transaction.commit()
        }

    }

}
