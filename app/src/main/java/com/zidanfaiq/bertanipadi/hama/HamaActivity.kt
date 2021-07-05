package com.zidanfaiq.bertanipadi.hama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.adapter.HamaAdapter
import com.zidanfaiq.bertanipadi.data.Hama
import com.zidanfaiq.bertanipadi.databinding.ActivityHamaBinding
import java.util.*
import kotlin.collections.ArrayList

class HamaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHamaBinding
    val arrayList = ArrayList<Hama>()
    val displayList = ArrayList<Hama>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Hama"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.rvDataHama.setHasFixedSize(true)

        arrayList.add(Hama("Tikus",
            "Tikus sawah (Rattus argentiventer) merupakan hama padi utama di Indonesia, kerusakan yang ditimbulkan cukup luas dan hampir terjadi setiap musim. Tikus memiliki daya adaptasi tinggi, sehingga mudah tersebar di dataran rendah dan dataran tinggi. Mereka suka menggali liang untuk berlindung dan berkembang biak, membuat terowongan atau jalur sepanjang pematang dan tanggul irigasi.\n" +
                    "Tikus sawah termasuk omnivora (pemakan segala jenis makanan). Apabila makanan berlimpah mereka cenderung memilih yang paling disukai, yaitu biji-bijian/padi yang tersedia di sawah. Tikus dapat menyerang seluruh fase pertumbuhan tanaman padi bahkan pada fase penyimpanan. Kerusakan terparah terjadi pada fase generatif, karena tanaman padi sudah tidak mampu lagi membentuk anakan baru. Pada umumnya tikus menyerang pada malam hari sedangkan pada siang hari tikus bersembunyi, pada periode bera sebagian besar tikus bermigrasi ke pemukiman dan kembali lagi menjelang fase generatif.",
            "a. Padi mengalami kerusakan sejak dari persemaian hingga dalam penyimpanan.\n" +
                    "b. Tanaman yang terserang banyak bekas potongan dan terdapat bekas gigitan.\n" +
                    "c. Kerusakan tanaman banyak terlihat pada pagi hari.",
            "a. Melakukan penanaman secara serentak supaya masa perkembangbiakan tikus menjadi singkat.\n" +
                    "b. Mempersempit area pematang sawah dengan tinggi dan lebar kurang dari 30 cm.\n" +
                    "c. Membersihkan seluruh areal pertanaman padi agar tikus tidak dapat membuat sarang.\n" +
                    "d. Pemanfaatan musuh alami tikus.\n" +
                    "e. Pemasangan perangkap tikus pagar plastik pada persemaian dan lahan sawah.\n" +
                    "f. Gropyokan dan pembongkaran sarang tikus.\n" +
                    "g. Pengendalian kimiawi menggunakan rodentisida apabila populasi tikus sudah tinggi.",
            R.drawable.tikus)
        )

        arrayList.add(Hama("Wereng",
            "Wereng coklat (Nilaparvata lugens Stal.) merupakan hama dari golongan insekta yang sangat merugikan usaha tani padi. Serangan wereng coklat yang sangat berarti mengurangi hasil padi secara substansial, mengakibatkan kerugian di tingkat petani. Wereng menyerang pada smua stadia pertumbuhan padi dengan cara menghisap cairan tanaman. Populasi tinggi wereng coklat dapat menyebabkan daun berubah kuning oranye sebelum menjadi coklat dan mati. Kondisi ini disebut hopperburn, membunuh tanaman Wereng coklat juga dapat menularkan penyakit kerdil hampa dan kerdil rumput yang sampai saat ini tidak bisa diobati.",
            "a. Banyak binatang kecil di tempat lembab, gelap dan teduh.\n" +
                    "b. Banyak malai dan bulir padi yang hampa.\n" +
                    "c. Tanaman terkena virus penyakit kerdil.",
            "a. Membersihkan gulma dari sawah dan areal sekitarnya.\n" +
                    "b. Penggunaan varietas unggul tahan wereng.\n" +
                    "c. Menggunakan perangkap cahaya.\n" +
                    "d. Penanaman padi dengan sistem jajar legowo.\n" +
                    "e. Melakukan pemupukan secara berimbang.\n" +
                    "f. Pengendalian menggunakan musuh alami/predator dengan melakukan pengamatan minimal 1 minggu 1 kali dan gunakan insektisida yang selektif untuk menghindari terbunuhnya musuh alami tersebut.",
            R.drawable.wereng)
        )

        arrayList.add(Hama("Keong Mas",
            "Keong mas dapat menyebabkan kerusakan tanaman berkisar 10 – 40%. Keong mas bersifat herbivor yang pemakan segala dan sangat rakus, tanaman yang disukai tanaman yang masih muda dan lunak seperti bibit padi. Apabila habitatnya dalam keadaan kekurangan air maka keong mas akan membenamkan diri pada lumpur yang dalam, hal ini dapat bertahan selama 6 bulan. Bila habitatnya sudah ada airnya maka keong mas akan muncul kembali pada saat pengolahan lahan. Keong mas siap melakukan kopulasi pada saat kondisi air terpenuhi pada areal persawahan. Serangan keong mas pada tanaman padi biasanya pada masa vegetatif dari masa pembibitan. Keong mas ini merusak tanaman padi dengan mengikis (memarut) jaringan tanaman lalu memakannya.",
            "a. Daun dan batang hilang dari pertanaman.\n" +
                    "b. Batang, tangkai dan helai daun yang rusak.\n" +
                    "c. Potongan daun dan batang banyak mengambang.",
            "a. Mengumpulkan telur dan keong mas pada saat pagi atau sore hari di tempat yang tergenang.\n" +
                    "b. Memasang penghalang plastik pada persemaian keong mas tidak dapat masuk ke dalam persemaian.\n" +
                    "c. Melakukan penyulaman tanaman padi yang terserang hama keong mas.\n" +
                    "d. Memasang tongkat/kayu pada areal persawahan tanaman padi untuk memerangkap keong mas yang akan melakukan peneluran.\n" +
                    "e. Melepaskan bebek untuk mengais rontokan padi serta memakan keong-keong kecil dan telur.\n" +
                    "f. Membuat perangkap umpan menggunakan dedaunan untuk menarik perhatian keong mas.\n" +
                    "g. Memasang saringan pada saluran masuk ke persawahan untuk menghindari masuknya keong mas dari saluran irigasi.\n" +
                    "h. Pengendalian kimia menggunakan Moluskisida dengan baik.\n",
            R.drawable.keong)
        )

        arrayList.add(Hama("Walang Sangit",
            "Walang sangit (L. oratorius L) merupakan salah satu hama yang menyerang tanaman padi sawah. Tanaman padi yang terserang walang sangit biasanya ditanam di sawah dekat hutan dan serangan walang sangit juga dapat terjadi pada tanaman padi yang terlambat tanam. Walang sangit mengisap isi biji padi pada bulir matang susu (milk), bulir yang lunak (soft dough), dan bulir yang keras (hard dough). Aktifitas paling banyak walang sangit mengisap bulir padi pada saat pagi dan sore hari.\n" +
                    "Hama walang sangit ini pada tanaman padi dapat menyebabkan kehilangan hasil hingga mencapai 50%. Hasil penelitian menunjukkan populasi walang sangit 5 ekor per 9 rumpun padi akan menurunkan hasil 15%. Hubungan antara kepadatan populasi walang sangit dengan penurunan hasil menunjukkan bahwa  serangan satu ekor walang sangit per malai dalam satu minggu dapat menurunkan hasil 27%. Kualitas gabah (beras) yang terserang oleh walang sangit akan berkurang. Diantaranya menyebabkan meningkatnya Grain dis-coloration perubahan warna pada gabah ataupun beras yang dihasilkan. Serangan walang sangit dapat menurunkan produksi dan menurunkan kualitas gabah.",
            "a. Kematian malai (Bulir padi rusak dan hampa).\n" +
                    "b. Padi rusak pada fase matang susu.\n" +
                    "c. Terdapat bekas tusukan berupa bercak putih.",
            "a. Membersihkan gulma di pematang, pertanaman, dan di sekeliling tanaman padi.\n" +
                    "b. Memasang bangkai binatang. Walang sangit tertarik kapada bau bangkai, setelah berkumpul dapat disemprot dengan insektisida.\n" +
                    "c. Menggunakan bahan kimia (Decis, Regent, BPMC) bila populasi sudah mencapai ambang ekonomi 10 ekor/20rpn.",
            R.drawable.walang)
        )

        arrayList.add(Hama("Burung",
            "Burung pipit adalah jenis hama dari kelas unggas (aves) pemakan biji-bijian yang menyerang malai pada tanaman padi untuk memakan biji atau bulir padi yang dapat menyebabkan petani mengalami kehilangan 30% sampai 50% hasil produksi. Burung menimbulkan kerusakan parah apabila terjadi perbedaan waktu tanam yang signifikan (lebih dari 3 minggu) daripada hamparan sawah disekitarnya. Burung akan menyerang tanaman yang sudah berumur 70 sampai 80 hari, saat bulir-bulir padi terisi.",
            "a. Padi banyak terserang saat fase mata susu sampai padi panen.\n" +
                    "b. Patahnya malai padi dan bulir padi mengering.\n" +
                    "c. Banyak biji hampa dan hilang karena rontok.",
            "a. Melakukan penanaman dan panen serentak untuk membatasi ketersediaan pakan bagi burung.\n" +
                    "b. Membuat perangkap jaring agar agar burung dapat menjauh dari pertanaman.\n" +
                    "c. Menggunakan rendaman jengkol karena aroma jengkol tidak disukai oleh burung.\n" +
                    "d. Memasang benda-benda mengkilap seperti plastik atau bekas piringan cakram.\n" +
                    "e. Menggunakan orang-orangan sawah",
            R.drawable.burung)
        )

        displayList.addAll(arrayList)

        binding.rvDataHama.layoutManager = GridLayoutManager(this, 2)
        val DataHamaAdapter = HamaAdapter(displayList, this)
        binding.rvDataHama.adapter = DataHamaAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView
            val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint = "Cari.."

            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        arrayList.forEach {
                            if (it.nama_hama.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                            binding.rvDataHama.adapter!!.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        binding.rvDataHama.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}