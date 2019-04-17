package com.example.nhom13;

        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.BaseAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gvDanhSachLogo;

    String[] DanTriCaption = {"Tư vấn","Phóng sự","Thời trang","Khuyến học","Thể thao","Thế giới","Kinh doanh","Ô tô","Tình yêu","Chuyện lạ"};
    String[] DanTriURL = {"https://dantri.com.vn/suc-khoe/tu-van.rss","https://dantri.com.vn/xa-hoi/phong-su-ky-su.rss","https://dantri.com.vn/giai-tri/thoi-trang.rss","https://dantri.com.vn/giao-duc-khuyen-hoc/khuyen-hoc.rss","https://dantri.com.vn/the-thao/bong-da-trong-nuoc.rss","https://dantri.com.vn/the-gioi/kieu-bao.rss","https://dantri.com.vn/kinh-doanh/doanh-nghiep.rss","https://dantri.com.vn/o-to-xe-may/thi-truong-xe.rss","https://dantri.com.vn/tinh-yeu-gioi-tinh/tinh-yeu.rss","https://dantri.com.vn/chuyen-la.rss"};
    String[] ThanhNienCaption = {"Pháp luật","Thế giới","Văn hóa","Thể thao","Đời sống","Tài chính - Kinh doanh","Giới trẻ","Giáo dục","Công nghệ","Giới tính"};
    String[] ThanhNienURL = {"https://thanhnien.vn/rss/viet-nam/phap-luat.rss","https://thanhnien.vn/rss/the-gioi/nguoi-viet-nam-chau.rss","https://thanhnien.vn/rss/van-hoa/cau-chuyen.rss","https://thethao.thanhnien.vn/rss/bong-da-viet-nam.rss","https://thanhnien.vn/rss/doi-song/cong-dong.rss","https://thanhnien.vn/rss/kinh-te/chung-khoan.rss","https://thanhnien.vn/rss/the-gioi-tre/hoat-dong-doanhoi.rss","https://thanhnien.vn/rss/giao-duc/du-hoc.rss","https://thanhnien.vn/rss/cong-nghe-thong-tin/san-pham-moi.rss","https://thanhnien.vn/rss/doi-song/gioi-tinh.rss"};
    String[] VnExpressCaption = {"Thời sự","Thế giới","Kinh doanh","Giải trí","Thể thao","Pháp luật","Giáo dục","Sức khỏe","Đời sống","Du lịch"};
    String[] VnExpressURL = {"https://vnexpress.net/rss/thoi-su.rss","https://vnexpress.net/rss/the-gioi.rss","https://vnexpress.net/rss/kinh-doanh.rss","https://vnexpress.net/rss/giai-tri.rss","https://vnexpress.net/rss/the-thao.rss","https://vnexpress.net/rss/phap-luat.rss","https://vnexpress.net/rss/giao-duc.rss","https://vnexpress.net/rss/suc-khoe.rss","https://vnexpress.net/rss/gia-dinh.rss","https://vnexpress.net/rss/du-lich.rss"};
    String[] Bao24hCaption = {"Tư vấn","Phóng sự","Thời trang","Khuyến học","Thể thao","Thế giới","Kinh doanh","Ô tô","Tình yêu","Chuyện lạ"};
    String[] Bao24hURL = {"https://dantri.com.vn/suc-khoe/tu-van.rss","https://dantri.com.vn/xa-hoi/phong-su-ky-su.rss","https://dantri.com.vn/giai-tri/thoi-trang.rss","https://dantri.com.vn/giao-duc-khuyen-hoc/khuyen-hoc.rss","https://dantri.com.vn/the-thao/bong-da-trong-nuoc.rss","https://dantri.com.vn/the-gioi/kieu-bao.rss","https://dantri.com.vn/kinh-doanh/doanh-nghiep.rss","https://dantri.com.vn/o-to-xe-may/thi-truong-xe.rss","https://dantri.com.vn/tinh-yeu-gioi-tinh/tinh-yeu.rss","https://dantri.com.vn/chuyen-la.rss"};
    String[] DSPLCaption = {"Pháp luật","Thế giới","Văn hóa","Thể thao","Đời sống","Tài chính - Kinh doanh","Giới trẻ","Giáo dục","Công nghệ","Giới tính"};
    String[] DSPLURL = {"https://thanhnien.vn/rss/viet-nam/phap-luat.rss","https://thanhnien.vn/rss/the-gioi/nguoi-viet-nam-chau.rss","https://thanhnien.vn/rss/van-hoa/cau-chuyen.rss","https://thethao.thanhnien.vn/rss/bong-da-viet-nam.rss","https://thanhnien.vn/rss/doi-song/cong-dong.rss","https://thanhnien.vn/rss/kinh-te/chung-khoan.rss","https://thanhnien.vn/rss/the-gioi-tre/hoat-dong-doanhoi.rss","https://thanhnien.vn/rss/giao-duc/du-hoc.rss","https://thanhnien.vn/rss/cong-nghe-thong-tin/san-pham-moi.rss","https://thanhnien.vn/rss/doi-song/gioi-tinh.rss"};
    String[] VietnamNetCaption = {"Thời sự","Thế giới","Kinh doanh","Giải trí","Thể thao","Pháp luật","Giáo dục","Sức khỏe","Đời sống","Du lịch"};
    String[] VietnamNetURL = {"https://vnexpress.net/rss/thoi-su.rss","https://vnexpress.net/rss/the-gioi.rss","https://vnexpress.net/rss/kinh-doanh.rss","https://vnexpress.net/rss/giai-tri.rss","https://vnexpress.net/rss/the-thao.rss","https://vnexpress.net/rss/phap-luat.rss","https://vnexpress.net/rss/giao-duc.rss","https://vnexpress.net/rss/suc-khoe.rss","https://vnexpress.net/rss/gia-dinh.rss","https://vnexpress.net/rss/du-lich.rss"};
//    String[] DanTriCaption = {"Tư vấn","Phóng sự","Thời trang","Khuyến học","Thể thao","Thế giới","Kinh doanh","Ô tô","Tình yêu","Chuyện lạ"};
//    String[] DanTriURL = {"http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001"};
//    String[] ThanhNienCaption = {"Pháp luật","Thế giới","Văn hóa","Thể thao","Đời sống","Tài chính - Kinh doanh","Giới trẻ","Giáo dục","Công nghệ","Giới tính"};
//    String[] ThanhNienURL = {"http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001"};
//    String[] VnExpressCaption = {"Thời sự","Thế giới","Kinh doanh","Giải trí","Thể thao","Pháp luật","Giáo dục","Sức khỏe","Đời sống","Du lịch"};
//    String[] VnExpressURL = {"http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001"};
//    String[] Bao24hCaption = {"Tư vấn","Phóng sự","Thời trang","Khuyến học","Thể thao","Thế giới","Kinh doanh","Ô tô","Tình yêu","Chuyện lạ"};
//    String[] Bao24hURL = {"http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001"};
//    String[] DSPLCaption = {"Pháp luật","Thế giới","Văn hóa","Thể thao","Đời sống","Tài chính - Kinh doanh","Giới trẻ","Giáo dục","Công nghệ","Giới tính"};
//    String[] DSPLURL = {"http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001"};
//    String[] VietnamNetCaption = {"Thời sự","Thế giới","Kinh doanh","Giải trí","Thể thao","Pháp luật","Giáo dục","Sức khỏe","Đời sống","Du lịch"};
//    String[] VietnamNetURL = {"http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001","http://www.npr.org/rss/rss.php?id=1001"};

    Integer[] MyLogo = {R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5, R.drawable.logo_6};
    String[] DanhSachBao = {"Dân trí","Thanh Niên","VnExpress","24h.com.vn","Đời sống và Pháp Luật","VietnamNet"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvDanhSachLogo = (GridView) findViewById(R.id.gvDanhSachLogo);
        gvDanhSachLogo.setAdapter(new MyImageAdapter(this,MyLogo));
        gvDanhSachLogo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                    {
                        Intent callShowChannel = new Intent( MainActivity.this, ShowChannel.class);

                        Bundle myData = new Bundle();
                        myData.putString("TenBao",DanhSachBao[position]);
                        myData.putInt("Logo",R.drawable.logo_1);
                        myData.putStringArray("Caption",DanTriCaption);
                        myData.putStringArray("URL",DanTriURL);
                        callShowChannel.putExtras(myData);

                        startActivity(callShowChannel);
                        break;
                    }
                    case 1:
                    {
                        Intent callShowChannel = new Intent( MainActivity.this, ShowChannel.class);

                        Bundle myData = new Bundle();
                        myData.putString("TenBao",DanhSachBao[position]);
                        myData.putInt("Logo",R.drawable.logo_2);
                        myData.putStringArray("Caption",ThanhNienCaption);
                        myData.putStringArray("URL",ThanhNienURL);
                        callShowChannel.putExtras(myData);

                        startActivity(callShowChannel);
                        break;
                    }
                    case 2:
                    {
                        Intent callShowChannel = new Intent( MainActivity.this, ShowChannel.class);

                        Bundle myData = new Bundle();
                        myData.putString("TenBao",DanhSachBao[position]);
                        myData.putInt("Logo",R.drawable.logo_3);
                        myData.putStringArray("Caption",VnExpressCaption);
                        myData.putStringArray("URL",VnExpressURL);
                        callShowChannel.putExtras(myData);

                        startActivity(callShowChannel);
                        break;
                    }
                    case 3:
                    {
                        Intent callShowChannel = new Intent( MainActivity.this, ShowChannel.class);

                        Bundle myData = new Bundle();
                        myData.putString("TenBao",DanhSachBao[position]);
                        myData.putInt("Logo",R.drawable.logo_4);
                        myData.putStringArray("Caption",Bao24hCaption);
                        myData.putStringArray("URL",Bao24hURL);
                        callShowChannel.putExtras(myData);

                        startActivity(callShowChannel);
                        break;
                    }
                    case 4:
                    {
                        Intent callShowChannel = new Intent( MainActivity.this, ShowChannel.class);

                        Bundle myData = new Bundle();
                        myData.putString("TenBao",DanhSachBao[position]);
                        myData.putInt("Logo",R.drawable.logo_5);
                        myData.putStringArray("Caption",DSPLCaption);
                        myData.putStringArray("URL",DSPLURL);
                        callShowChannel.putExtras(myData);

                        startActivity(callShowChannel);
                        break;
                    }
                    case 5:
                    {
                        Intent callShowChannel = new Intent( MainActivity.this, ShowChannel.class);

                        Bundle myData = new Bundle();
                        myData.putString("TenBao",DanhSachBao[position]);
                        myData.putInt("Logo",R.drawable.logo_6);
                        myData.putStringArray("Caption",VietnamNetCaption);
                        myData.putStringArray("URL",VietnamNetURL);
                        callShowChannel.putExtras(myData);

                        startActivity(callShowChannel);
                        break;
                    }
                }
            }
        });
    }
}

class MyImageAdapter extends BaseAdapter {
    private Context context;
    private Integer[] MyLogo;
    public MyImageAdapter(Context context, Integer[] MyLogo)
    {
        this.context = context;
        this.MyLogo = MyLogo;
    }
    public int getCount() {
        return MyLogo.length;
    }
    public Object getItem(int position) {
        return MyLogo[position];
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams( new GridView.LayoutParams(300, 300) );
            imageView.setPadding(30, 30, 30, 30);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(MyLogo[position]);
        return imageView;
    }
}
