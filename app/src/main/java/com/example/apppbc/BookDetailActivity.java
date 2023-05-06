package com.example.apppbc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppbc.api.ApiFilm;
import com.example.apppbc.model.Bill;
import com.example.apppbc.model.ResUrl;
import com.example.apppbc.model.Ticket;
import com.example.apppbc.model.User;
import com.example.apppbc.model.UserSession;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetailActivity extends AppCompatActivity {
    GridLayout gridLayout;
    private TextView tvTicket;
    private TextView tvAmount;
    List<String> ticket_str ;
    private RelativeLayout relativeLayout;
    private Button tt;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        gridLayout = findViewById(R.id.gridview);

        setClick(gridLayout);
        tt = findViewById(R.id.buttonTt);

        String id = UserSession.getInstance().getUsername();

        LocalDateTime now = LocalDateTime.now();
        User user = new User(Long.parseLong(id));

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amountT = Double.parseDouble(tvAmount.getText().toString().replaceAll("[^\\d]", ""));
                String tickets = tvTicket.getText().toString();
                String[] ticket = tickets.split(",");
                List<String> list = new ArrayList<String>(Arrays.asList(ticket));

                List<Ticket> listTickets1 = new ArrayList<>();
                for(String i: list){
                    Ticket ticket1 = new Ticket();
                    ticket1.setName(i);
                    listTickets1.add(ticket1);
                }
                Bill bill = new Bill(null,null,amountT,user,listTickets1);

//                saveBill(bill);
               callVnPay(amountT);
            }
        });
    }

    private void callVnPay(double amount) {
        ApiFilm.apiFilm.getPay(amount).enqueue(new Callback<ResUrl>() {
            @Override
            public void onResponse(Call<ResUrl> call, Response<ResUrl> response) {
                ResUrl url = response.body();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url.getUrl()));
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResUrl> call, Throwable t) {
                Toast.makeText(BookDetailActivity.this, "ngoo_pay",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveBill(Bill bill) {
        ApiFilm.apiFilm.saveBill(bill).enqueue(new Callback<Bill>() {
            @Override
            public void onResponse(Call<Bill> call, Response<Bill> response) {

                Bill bill1 = response.body();
                System.out.println(bill.toString());
               System.out.println(bill1.toString());
                Toast.makeText(BookDetailActivity.this, "khon_sa",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Bill> call, Throwable t) {
                Toast.makeText(BookDetailActivity.this, "ngoo_sa",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setClick(GridLayout gridLayout) {
        tvTicket = findViewById(R.id.tv_ticket);
        tvAmount = findViewById(R.id.tv_amount);
        ticket_str = new ArrayList<>();
        for(int i = 0; i<gridLayout.getChildCount();i++){
            final  CardView cardView = (CardView) gridLayout.getChildAt(i);
            final Integer fi = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(Color.parseColor("#B366FF"));
                    if( cardView.getCardBackgroundColor().getDefaultColor()==Color.parseColor("#B366FF")){


                        ticket_str.add(getP(fi));

                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        cardView.invalidate();



                    }
                    else{
                        cardView.setCardBackgroundColor(Color.parseColor("#B366FF"));
                        cardView.invalidate();
                        ticket_str.remove(getP(fi));

                    }
                    DecimalFormat decimalFormat = new DecimalFormat("#,##");
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
                    tvAmount.setText(formatter.format(ticket_str.size()*90000));
                    tvTicket.setText(String.join(",", ticket_str));
                }
            });

        }

    }
    private String getP(int i) {
        int totalBlocks = 30;
        int numColumns = 6;

// Tính toán số hàng của mỗi block
        int numRows = (int) Math.ceil((double) totalBlocks / numColumns);

// Khởi tạo mảng chứa kí tự cho từng block
        String[] blockChars = new String[totalBlocks];

// Gắn kí tự cho từng block
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                int blockIndex = row * numColumns + col;
                if (blockIndex < totalBlocks) {
                    String rowChar = Character.toString((char) ('A' + row)); // Chuyển số hàng thành kí tự từ A đến Z
                    String colNum = String.format("%02d", col + 1); // Chuyển số cột thành chuỗi 2 chữ số
                    blockChars[blockIndex] = rowChar + colNum;
                }
            }
        }


        return blockChars[i];
    }
}