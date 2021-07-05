package com.zidanfaiq.bertanipadi.budidaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.zidanfaiq.bertanipadi.R
import com.zidanfaiq.bertanipadi.adapter.BudidayaAdapter
import com.zidanfaiq.bertanipadi.data.Budidaya
import com.zidanfaiq.bertanipadi.databinding.ActivityBudidayaBinding
import java.util.*
import kotlin.collections.ArrayList

class BudidayaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBudidayaBinding
    val arrayList = ArrayList<Budidaya>()
    val displayList = ArrayList<Budidaya>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBudidayaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Budidaya"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.rvDataBudidaya.setHasFixedSize(true)

        arrayList.add(Budidaya("Pemilihan Bibit",
            "Benih padi yang berkualitas merupakan hal yang penting jika kita ingin meningkatkan hasil budidaya padi. Saat ini di pasaran terdapat banyak varietas benih padi yang dapat Anda cocokkan dengan kondisi lahan serta permintaan pasar. Beberapa ciri dari beras varietas unggulan adalah Tahan terhadap serangan hama dan penyakit, Toleran terhadap kondisi lingkungan, Dapat mengasilkan panen yang berlimpah, dan Saat direndam dengan larutan ZA 20 gr, benih tenggelam alias tidak mengapung.",
            R.drawable.bibit)
        )

        arrayList.add(Budidaya("Persemaian",
            "Benih padi yang sudah siap dapat segera di semai, langkah-langkahnya adalah sebagai berikut :\n" +
                    "\na. Buatlah bedengan dengan ukuran lebar 1 – 2 m. Luas persemaian untuk lahan 1 hektar adalah sekitar 400 m atau 4% dari luas lahan.\n" +
                    "\nb. Tambahkan 2 kg bahan organik semisal kompos, pupuk kandang, sekam, atau abu. Jika Anda berminat untuk mengolah kompos dari bahan sisa pertanian, silahkan pelajaricara membuat pupuk kompos dari jerami padi.\n" +
                    "\nc. Benih yang hendak disemai haruslah direndam dahulu sekitar 2 x 24 jam.\n" +
                    "\nd. Persemaian dilakukan selama 25 hari sebelum masa tanam, usahakan tempat menyemai benih padi berdekatan dengan lokasi tanam agar pemindahan benih tersebut dilakukan dengan cepat dan benih tetap segar.\n" +
                    "\ne. Benih yang disemai tidak harus terbenam seluruhnya, karena justeru akan menyebabkan kecambah terinfeksi patogen dan akhirnya membusuk.",
            R.drawable.persemaian)
        )

        arrayList.add(Budidaya("Pengolahan Lahan",
            "Pengolahan lahan bertujuan untuk mengubah sifat fisik tanah agar lapisan yang semula keras menjadi datar dan melumpur. Dengan begitu gulma akan mati dan membusuk menjadi humus, aerasi tanah menjadi lebih baik, lapisan bawah tanah menjadi jenuh air sehingga dapat menghemat air. Pada pengolahan tanah sawah ini, dilakukan juga perbaikan dan pengaturan pematang sawah serta selokan. Pematang (galengan) sawah diupayakan agar tetap baik untuk mempermudah pengaturan irigasi sehingga tidak boros air dan mempermudah perawatan tanaman. Tahapan pengolahan tanah sawah pada prinsipnya mencakup kegiatan-kegiatan sebagai berikut :\n" +
                    "\na. Pembersihan\n" +
                    "Pematang sawah dibersihkan dari rerumputan, diperbaiki, dan dibuat agak tinggi. Fungsi utama pematang disaat awal untuk menahan air selama pengolahan tanah agar tidak mengalir keluar petakan. Fungsi selanjutnya berkaitan erat dengan pengaturan kebutuhan air selama ada tanaman padi.Saluran atau parit diperbaiki dan dibersihkan dari rerumputan. Kegiatan tersebut bertujuan agar dapat memperlancar arus air serta menekan jumlah biji gulma yang terbawa masuk ke dalam petakan. Sisa jerami dan sisa tanaman pada bidang olah dibersihkan sebelum tanah diolah. Jerami tersebut dapat dibakar atau diangkut ke tempat lain untuk pakan ternak, kompos, atau bahan bakar. Pembersihan sisasisa tanaman dapat dikerjakan dengan tangan dan cangkul\n" +
                    "\nb. Pencangkulan\n" +
                    "Setelah dilakukan perbaikan pematang dan saluran, tahap berikutnya adalah pencangkulan. Sudutsudut petakan dicangkul untuk memperlancar pekerjaan bajak atau traktor. Pekerjaan tersebut dilaksanakan bersamaan dengan saat pengolahan tanah.\n" +
                    "\nc. Pembajakan\n" +
                    "Pembajakan dan penggaruan merupakan kegiatan yang berkaitan. Kedua kegiatan tersebut bertujuan agar tanah sawah melumpur dan siap ditanami padi. Pengolahan tanah dilakukan dengan dengan menggunakan mesin traktor. Sebelum dibajak, tanah sawah digenangi air agar gembur. Lama penggenangan sawah dipengaruhi oleh kondisi tanah dan persiapan tanam.\n" +
                    "Pembajakan biasanya dilakukan dua kali. Dengan pembajakan ini diharapkan gumpalan-gumpalan tanah terpecah menjadi kecil-kecil. Gumpalan tanah tersebut kemudian dihancurkan dengan garu sehingga menjadi lumpur halus yang rata. Keuntungan tanah yang telah diolah tersebut yaitu air irigasi dapat merata. Pada petakan sawah yang lebar, perlu dibuatkan bedengan-bedengan. Antara bedengan satu dengan bedeng lainnya berupa saluran kecil. Ujung saluran bertemu dengan parit kecil di tepi pematang yang berguna untuk memperlancar air irigasi.",
            R.drawable.bajak)
        )

        arrayList.add(Budidaya("Penanaman",
            "Setelah persiapan lahan beres maka bibit pun siap ditanam. Bibit dianjurkan untuk ditanam semuda mungkin, biasanya dipindah saat umur 20 hari. Ciri bibit yang siap dipindah ialah berdaun 5-6 helai, tinggi 22-25 cm, batang bawah besar dan keras, bebas dari hama dan penyakit sehingga pertumbuhannya seragam. Bibit ditanam dengan cara dipindah dari bedengan persemaian ke petakan sawah, dengan cara bibit dicabut dari bedengan persemaian dengan menjaga agar bagian akarnya terbawa semua dan tidak rusak. Setelah itu bibit dikumpulkan dalam ikatan-ikatan lalu ditaruh disawah dengan sebagian akar terbenam ke air.\n" +
                    "\nBibit ditanam cukup satu bibit per lubang tanam, dengan posisi tegak dan apabila petani masih belum terbiasa dengan menanam satu bibit, pada tahap awal dapat menanam 2-3 bibit per lubang tanam, dengan kedalaman tanam cukup 2 cm, karena jika kurang dari 2 cm bibit akan gampang hanyut. Pengaturan jarak tanam dilakukan dengan caplak, Jarak tanam padi model tegel biasanya 20 cm x 20 cm atau 25 cm x 25 cm. Model sistem tanam jajar legowo juga sudah banyak diterapkan yaitu legowo 2 : 1 (40 x 20 x 10 cm) adalah cara tanam berselang seling 2 baris dan 1 bari kosong. Jarak antar baris tanaman yang dikosongkan di sebut satu unit.",
            R.drawable.nanam)
        )

        arrayList.add(Budidaya("Pemupukan",
            "Tanah yang dibudidayakan secara terus menerus cenderung kekurangan unsur hara bagi tanaman, oleh karena itu diperlukan penambahan unsur hara yang berasal dari pupuk organik maupun pupuk anorganik. Agar efektif dan efisien penggunaan pupuk disesuaikan dengan kebutuhan tanaman dan ketersediaan hara dalam tanah. Kebutuhan N tanaman dapat diketahui dengan cara mengukur tingkat kehijauan warna daun padi dengan menggunakan Bagan Warna Daun (BWD).\n" +
                    "\nCara menentukan waktu aplikasi pupuk N dengan menggunakan BWD dapat dilakukan dengan 2 cara sebagai berikut :\n" +
                    "\nCara pertama adalah waktu tetap, yaitu waktu pemupukan di tetapkan lebih dahulu berdasarkan tahap pertumbuhan tanaman, antara lain fase pada saat anakan akif dan pembentukan malai dan saat primordia.\n" +
                    "\nCara kedua adalah waktu pemberian pupuk berdasarkan nilai pembacaan BWD yang sebenarnya yaitu penggunaan BWD dimulai ketika tanaman 14 HST, kemudian secara periodik diulangi 7-10 hari sekali sampai diketahui nilai kritis saat pupuk N harus diaplikasikan.",
            R.drawable.pemupukan)
        )

        arrayList.add(Budidaya("Perawatan dan Pemeliharaan",
            "Perawatan dan pemeliharaan tanaman sangat penting dalam pelaksanaan budidaya padi sawah. Hal-hal yang sering dilakukan oleh para petani adalah penyiangan (pengendalian gulma). Gulma merupakan tumbuhan pengganggu yang hidup bersama tanaman yang dibudidayakan dan pada umumnya sangat merugikan tanaman padi. Disamping dapat menjadi tanaman inang beberapa hama dan penyebab penyakit, gulma merupakan pesaing untuk unsur hara air, tempat dan sinar matahari. Apalagi gulma memiliki sistem perakaran yang sama dengan padi sehingga unsur makanan yang diperlukan oleh gulma dan padi berasal dari lapisan tanah yang sama. Penyiangan gulma dilakukan 2 tahap, dimana tahap pertama penyiangan dilakukan pada saat umur tanaman kurang lebih 15 hari dan tahap kedua pada saat umur tanaman berumur 30-35 hari. Penyiangan yang dilakukan dengan cara mencabut gulma dan dimatikan dengan atau tanpa menggunakan alat, biasanya penyiangan ini dilakukan bersamaan dengan dengan kegiatan penyulaman.",
            R.drawable.penyiangan)
        )

        arrayList.add(Budidaya("Pemanenan",
            "Tujuan pemanenan padi adalah untuk mendapatkan gabah dari lapangan pada tingkat kematangan optimal, mencegah kerusakan dan kehilangan hasil seminimal mungkin. Pemanenan padi tidak akan menguntungkan dan memuaskan jika prosesnya dilakukan dengan cara yang kurang benar dan pada umur panen yang tidak tepat. Cara panen yang tidak baik akan menurunkan kehilangan hasil secara kuantitatif, sedang saat panen yang tepat akan menentukan kualitas gabah dan beras. Panen harus dilakukan bila bulir padi sudah cukup dianggap masak. Panen yang kurang tepat dapat menurunkan kualitas dari gabah maupun beras.\n" +
                    "\na. Ciri-ciri Padi Siap Panen\n" +
                    "- Daun bendera telah mengering dan 95% gabah sudah menguning.\n" +
                    "- Umur optimal malai 30 sampai 35 hari terhitung sejak hari sesudah berbunga (HSB). Tergantung varietas yang dibudidayakan.\n" +
                    "- Kadar air gabah berkisar antara 21 sampai 26.\n" +
                    "- Kerontokan gabah sekitar 16 sampai 30 % (Cara mengukurnya dengan meremas malai dengan tangan).\n" +
                    "\nb. Cara Panen Padi\n" +
                    "Dalam melakukan pemanenan padi dapat dilakukan dengan berbagai cara, tergantung dari alat yang digunakan, varietas padi dan cara merontokkan gabah yang akan dilakukan. Berikut ini beberapa cara dalam memanen padi :\n" +
                    "- Ani-ani umumnya digunakan petani untuk memanen padi lokal yang tahan rontok dan tanaman padi berpostur tinggi dengan cara memotong pada tangkainya.\n" +
                    "- Cara panen padi varietas unggul baru dengan sabit dapat dilakukan dengan cara potong atas, potong tengah atau potong bawah tergantung cara perontokannya.\n" +
                    "- Cara panen dengan potong bawah, umumnya dilakukan bila perontokannya dengan cara dibanting/digebot atau menggunakan pedal thresher.\n" +
                    "- Panen padi dengan cara potong atas atau potong tengah bila dilakukan perontokannya menggunakan mesin perontok.",
            R.drawable.panen)
        )

        displayList.addAll(arrayList)

        binding.rvDataBudidaya.layoutManager = LinearLayoutManager(this)
        val DataBudidayaAdapter = BudidayaAdapter(displayList, this)
        binding.rvDataBudidaya.adapter = DataBudidayaAdapter
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
                            if (it.nama.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                            binding.rvDataBudidaya.adapter!!.notifyDataSetChanged()
                        }
                    } else {
                        displayList.clear()
                        displayList.addAll(arrayList)
                        binding.rvDataBudidaya.adapter!!.notifyDataSetChanged()
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