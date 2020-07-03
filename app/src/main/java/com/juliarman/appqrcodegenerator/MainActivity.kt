package com.juliarman.appqrcodegenerator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.rengwuxian.materialedittext.MaterialEditText


class MainActivity : AppCompatActivity() {

    private lateinit var BtnProses: Button
    private lateinit var BtnClear: Button
    private lateinit var NmProduk: MaterialEditText
    private lateinit var IdProduk: MaterialEditText
    private lateinit var HrgProduk: MaterialEditText
    private lateinit var DescProduk: MaterialEditText
    private lateinit var ImgBarcode: ImageView

    lateinit var tnama: TextView; lateinit var tid: TextView; lateinit var tharga: TextView; lateinit var tdesc: TextView;

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tnama = findViewById(R.id.txtnm)
        tid = findViewById(R.id.txtid)
        tharga = findViewById(R.id.txthrg)
        tdesc = findViewById(R.id.txtdesc)


        NmProduk = findViewById(R.id.NmProduk)
        IdProduk = findViewById(R.id.IdProduk)
        HrgProduk = findViewById(R.id.HrgProduk)
        DescProduk = findViewById(R.id.desc_produk)
        ImgBarcode = findViewById(R.id.imgbarcode)
        BtnProses = findViewById(R.id.btn_proses)
        BtnClear = findViewById(R.id.btn_clear)

        BtnProses.setOnClickListener{

            try {

                tnama.setText(NmProduk.text)
                tid.setText(IdProduk.text)
                tharga.setText(HrgProduk.text)
                tdesc.setText(DescProduk.text)

                val QrCode  = BarcodeEncoder()
                val ImgCode = QrCode.encodeBitmap(IdProduk.text.toString(), BarcodeFormat.QR_CODE,
                    500, 500)
                ImgBarcode.setImageBitmap(ImgCode)

            } catch (e: Exception){

                e.printStackTrace()

            }
        }

        BtnClear.setOnClickListener{
            clear()
        }

    }

    fun clear(){

        NmProduk.setText(" ")
        IdProduk.setText(" ")
        HrgProduk.setText(" ")
        DescProduk.setText(" ")
        ImgBarcode.setImageResource(R.drawable.imgbg)
    }


}