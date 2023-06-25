package com.example.travelguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ListOfAttractionsActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;
    private Button tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_attractions);

        textView = findViewById(R.id.textView5);
        User user = getIntent().getParcelableExtra("user");
        textView.setText("Здравствуйте, " + user.getName() + "!");


        ArrayList<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction("Памятник Салавату Юлаеву", "Памятник Салава́ту Юла́еву — произведение советского скульптора-монументалиста Сосланбека Тавасиева в городе Уфа, посвящённое национальному герою Башкортостана Салавату Юлаеву.\n",
                new Point(55.75489, 37.62158), "2023.01.01", "2023.01.27"));

        attractions.add(new Attraction("Мечеть Ляля-Тюльпан", "Уфимская соборная мечеть «Ляля-Тюльпан» (башк. «Ләлә-Тюльпан» Өфө йәмиғ мәсете) — исламский культурный-образовательный центр в Уфе. Открыт 7 апреля 1998 года." + "\n" +
                               "Мечеть является мусульманским религиозным центром города Уфы, в ней проводятся мусульманские праздники.",
                new Point(54.819625, 56.055839), "2023.01.10", "2023.01.27"));

        attractions.add(new Attraction("Монумент Дружбы", "«Дру́жба» (башк. Дуҫлыҡ; разг. монумент Дружбы) — монумент в честь 400-летия присоединения (вхождения) исторического Башкортостана в состав Русского государства, на Первомайской площади в городе Уфе.",
                new Point(54.711826, 55.963464), "2023.01.08", "2023.01.28"));

        attractions.add(new Attraction("Фонтан «Семь девушек»",
                "Фонтан «Семь девушек», одна из главных достопримечательностей Уфы, был открыт летом 2015 года в реконструированном Театральном сквере, основном прогулочном месте центра города. Это самое большое сооружение подобного типа в Республике Башкортостан. " +
                        "Включает в себя 2 чаши, облицованные гранитом и скульптуры девушек, возвышающиеся на постаментах.",
                new Point(54.723423, 55.945151), "2023.01.20", "2023.01.28"));

        attractions.add(new Attraction("Уфа-Арена",
                "Универсальная спортивная арена «Уфа-Арена» (башк. Өфө-Арена) — многофункциональный спортивно-концертный комплекс в Уфе, домашняя арена российского хоккейного клуба «Салават Юлаев» (с 19 декабря 2007 года)." +
                        " Первый матч на арене состоялся 27 августа 2007 года в рамках молодёжной Суперсерии 2007 между хоккейными сборными России и Канады." ,
                new Point(54.739411, 55.957301), "2023.01.10", "2023.01.27"));

        attractions.add(new Attraction("Кафедральный собор Рождества Богородицы", "Кафедральный собор Рождества Богородицы (также — Рождественский собор; ранее — Рождественская церковь) — православный храм в Уфе, кафедральный собор (с мая 2016) Уфимской епархии и Башкортостанской митрополии Русской православной церкви." +
                " Самый вместительный православный храм города, который может принять в любые дни до нескольких тысяч человек одновременноnew" ,
                new Point(54.727280, 55.973565), "2023.01.21", "2023.01.27"));

        attractions.add(new Attraction("Конгресс-холл Торатау", "Конгресс-холл — Дом правительства в Уфе, построенный к 450-летию присоединения Башкортостана к России." +
                " Для его архитектуры характерно использование пространственных, формальных, колористических прототипов башкирской культуры для формирования современной национальной архитектуры." ,
                new Point(54.721052, 55.928795), "2023.01.20", "2023.01.27"));
        attractions.add(new Attraction("Три шурупа", "",
                new Point(54.720466, 55.944745), "2023.01.20", "2023.01.27"));
        attractions.add(new Attraction("Три шурупа x2", "",
                new Point(54.720466, 55.944745), "2023.01.20", "2023.01.27"));
        attractions.add(new Attraction("Три шурупа x3", "",
                new Point(54.720466, 55.944745), "2023.01.20", "2023.01.27"));
        attractions.add(new Attraction("Три шурупа x4", "",
                new Point(54.720466, 55.944745), "2023.01.20", "2023.01.27"));
        attractions.add(new Attraction("Три шурупа x5", "",
                new Point(54.720466, 55.944745), "2023.01.20", "2023.01.27"));
        attractions.add(new Attraction("Три шурупа x6", "",
                new Point(54.720466, 55.944745), "2023.01.20", "2023.01.27"));

        listView = findViewById(R.id.listView);
        ArrayAdapter<Attraction> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, attractions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Intent intent = new Intent(ListOfAttractionsActivity.this, AttractionActivity.class);
                intent.putExtra("attraction", attractions.get(position));
                startActivity(intent);
            }
        });

        tour = findViewById(R.id.tourButton);

        tour.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfAttractionsActivity.this, TourActivity.class);
            intent.putParcelableArrayListExtra("attractions", attractions);
            startActivity(intent);
        });
    }
}
