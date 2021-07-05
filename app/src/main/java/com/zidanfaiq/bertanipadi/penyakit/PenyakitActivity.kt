package com.zidanfaiq.bertanipadi.penyakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.adapter.PenyakitAdapter
import com.zidanfaiq.bertanipadi.data.Penyakit
import com.zidanfaiq.bertanipadi.databinding.ActivityPenyakitBinding
import java.util.*
import kotlin.collections.ArrayList

class PenyakitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPenyakitBinding
    val arrayList = ArrayList<Penyakit>()
    val displayList = ArrayList<Penyakit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenyakitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Penyakit"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.rvDataPenyakit.setHasFixedSize(true)

        arrayList.add(
            Penyakit("Hawar daun bakteri",
            "Penyakit hawar daun bakteri atau kresek disebabkan oleh bakteri Xanthomonas oryzae pv. oryzae (Xoo). Serangan yang terjadi pada awal pertumbuhan menyebabkan tanaman menjadi layu dan mati. Serangan oleh bakteri ini dapat terjadi pada fase vegetatif dan generatif yang mengakibatkan kerusakan tanaman serta menurunkan hasil produksi tanaman padi.\n" +
                    "Penyakit ini termasuk dalam kategori penyakit yang terbawa oleh benih (seed borne diseases). Penyakit akan berkembang dari benih padi yang terinfeksi oleh patogen. Faktor lain yang mempengaruhi perkembangan penyakit hawar daun bakteri adalah penggunaan varietas rentan penyakit hawar daun bakteri, pemupukan tidak berimbang, dan kondisi cuaca (kelembaban tinggi, suhu rendah, curah hujan tinggi dan angin kencang).",
            "a. Tanaman layu pada saat fase vegetatif.\n" +
                    "b. Tepi daun berwarna hijau keabuaan\n" +
                    "c. Terdapat daun yang mengering.",
            "a. Penanaman Benih dan bibit sehat\n" +
                    "b. Penanaman menggunakan system Legowo dan system pengairan secara berselang (intermitten irrigation).\n" +
                    "c. Tidak menggunakan pupuk urea terlau tinggi dan menggunakan pupuk N dan K secara berimbang.\n" +
                    "d. sanitasi lingkungan sawah dengan menjaga kebersihan sawah dari gulma.\n" +
                    "e. Pengendalian Penyakit HDB dengan Varietas Tahan.",
            R.drawable.kresek)
        )

        arrayList.add(
            Penyakit("Tungro",
                "Penyakit tungro disebabkan oleh dua jenis virus yang berbeda yaitu virus bentuk batang Rice Tungro Bacilliform Virus (RTBV) dan virus bentuk bulat Rice Tungro Spherical Virus (RTSV). Kedua jenis virus tersebut dapat menginfeksi tanaman secara bersama-sama. Virus tungro hanya ditularkan oleh wereng hijau atau wereng lainnya. Penularan virus tungro dapat terjadi apabila wereng memperoleh virus setelah mengisap tanaman yang terinfeksi virus kemudian berpindah dan mengisap tanaman sehat.",
                "a. Perubahan warna dari kuning hingga oranye dan terdapat bercak coklat.\n" +
                        "b. Daun yang masih muda berbentuk melintir.\n" +
                        "c. Perubahan warna dari ujung ke pangkal daun.\n" +
                        "d. Tanaman padi menjadi kerdil.",
                "a. Menanam padi serempak pada lahan luas minimal 25 hektar.\n" +
                        "b. Mengatur waktu tanam padi dengan sebaik-baiknya agar tanaman padi tidak rentan terhadap penyakit tungro.\n" +
                        "c. Memilih varietas tanaman padi yang berkualitas bagus, sehingga tidak mudah terserang wereng hijau dan virus tungro.\n" +
                        "d. Sanitasi lingkungan atau pembersihan lahan sebelum tanam dari sisa tanaman dan gulma.\n" +
                        "e. Melakukan pemupukan berimbang sesuai dosis.\n" +
                        "f. Menggunakan bahan insektisida pada fase sebelum semai dengan dosis yang masih aman.",
                R.drawable.tungro)
        )

        arrayList.add(
            Penyakit("Kerdil Rumput",
                "Penyakit kerdil hampa disebabkan oleh Rice Grassy Stunt Virus (RGSV). Virus tersebut disebarkan oleh hama wereng coklat. Penularan virus tungro dapat terjadi apabila wereng memperoleh virus setelah mengisap tanaman yang terinfeksi virus kemudian membawa virus untuk waktu yang lama dan menginfeksi tanaman baru secara terus-menerus dan merambat. Namun, wereng perlu memakan tanaman yang terinfeksi selama setidaknya 30 menit untuk mengambil virus. Virus ini dapat menginfeksi tanaman bersama-sama dengan virus kerdil hampa padi, dan menyebabkan kerugian yang besar.",
                "Penghambatan pertumbuhan, anakannya banyak, daunnya menjadi pendek dan sempit, dan tumbuhnya tegak serta berwarna hijau pucat atau kuning pucat. Seringkali pada daunnya terdapat bintik-bintik atau bercak coklat tua. Daunnya kadang-kadang tetap hijau jika diberi pupuk nitrogen yang cukup.",
                "a. Melebarkan jarak tanam untuk memungkinkan sinar matahari mencapai pangkal tanaman.\n" +
                        "b. Melakukan rotasi tanaman dan penanaman secara serempak.\n" +
                        "c. Penggunaan varietas yang lebih tahan terhadap serangan.\n" +
                        "d. Penggunaan pupuk secara berimbang.\n" +
                        "e. Menghilangkan sumber infeksi dengan mencabut dan membenamkan tanaman yang sudah terinfeksi .\n" +
                        "f. Pemanfaatan musuh alami wereng coklat\n" +
                        "g. Menggunakan insekstisida secara selektif.",
                R.drawable.kerdil_rumput)
        )

        arrayList.add(
            Penyakit("Kerdil Hampa",
                "Penyakit kerdil hampa disebabkan oleh Rice Ragged Stunt Virus (RRSV). Virus tersebut disebarkan oleh hama wereng coklat. Penularan virus ini dapat terjadi apabila wereng memperoleh virus setelah mengisap tanaman yang terinfeksi virus kemudian berpindah dan menghisap tanaman sehat.\n" +
                        "Tanaman akan menghasilkan sedikit atau sama sekali tiidak menghasilkan bulir pada keseluruhan tergantung dari seberapa banyak kerusakan yang ada pada tanaman.",
                "Pertumbuhan terhambat (kerdil), daun berwarna hijau gelap, tepi daun tidak rata, berlekuk-lekuk atau sobek-sobek, terjadi pembengkakan tulang daun atau membentuk puru. Pada stadia bibit akan berkembang daun baru dengan gejala yang jelas seperti daun melintir, dan tepi daun bergerigi pada 2 minggu setelah inokulasi. Pada stadia berbunga, daun atas dan daun bendera menunjukkan gejala melintir, malai tidak keluar atau keluar sebagian, dan dari malai yang sebagian keluar, gabah biasanya hampa.",
                "a. Penanaman menggunakan varietas unggul tahan wereng coklat\n" +
                        "b. Menghilangkan sumber infeksi dengan mencabut dan membenamkan tanaman yang sudah terinfeksi .\n" +
                        "c. Melakukan pergiliran tanaman (padi dengan palawijaya), pengaturan air irigasi, dan pemupukan berimbang.\n" +
                        "d. Pengendalian secara biologi dengan memanfaatkan musuh alami wereng coklat sperti laba-laba.\n" +
                        "e. Menggunakan insekstisida secara selektif.\n",
                R.drawable.kerdil_hampa)
        )

        displayList.addAll(arrayList)

        binding.rvDataPenyakit.layoutManager = GridLayoutManager(this, 2)
        val DataPenyakitAdapter = PenyakitAdapter(displayList, this)
        binding.rvDataPenyakit.adapter = DataPenyakitAdapter
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
                            if (it.nama_penyakit.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                            binding.rvDataPenyakit.adapter!!.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        binding.rvDataPenyakit.adapter!!.notifyDataSetChanged()
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