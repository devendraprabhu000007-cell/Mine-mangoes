package com.minemangoes.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout root;
    LinearLayout content;
    TextView title;

    int gold = Color.rgb(255, 179, 0);
    int dark = Color.rgb(18, 18, 18);
    int card = Color.rgb(30, 30, 30);
    int white = Color.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    TextView text(String value, int size) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(white);
        t.setPadding(20, 16, 20, 16);
        return t;
    }

    Button button(String value) {
        Button b = new Button(this);
        b.setText(value);
        b.setTextColor(white);
        b.setTextSize(14);
        return b;
    }

    void base(String screenTitle) {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(dark);

        title = text(screenTitle, 25);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(gold);
        root.addView(title);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(10, 10, 10, 10);

        ScrollView scroll = new ScrollView(this);
        scroll.addView(content);

        root.addView(scroll,
                new LinearLayout.LayoutParams(
                        -1, 0, 1));

        LinearLayout nav = new LinearLayout(this);
        nav.setGravity(Gravity.CENTER);
        nav.setBackgroundColor(Color.rgb(25,25,25));

        String[] names = {"Home", "Search", "Library", "Party", "Profile"};

        for (String name : names) {
            Button b = button(name);
            nav.addView(b, new LinearLayout.LayoutParams(
                    0, 65, 1));

            if (name.equals("Home"))
                b.setOnClickListener(v -> showHome());
            else if (name.equals("Search"))
                b.setOnClickListener(v -> showSearch());
            else if (name.equals("Library"))
                b.setOnClickListener(v -> showLibrary());
            else if (name.equals("Party"))
                b.setOnClickListener(v -> showParty());
            else
                b.setOnClickListener(v -> showProfile());
        }

        root.addView(nav);
        setContentView(root);
    }

    void showHome() {
        base("🥭 MINE MANGOES");

        add("Your Music. Your World. Your Vibe.", 18);

        add("Made For You", 21);
        add("🎵 Daily Mix", 17);
        add("🔥 Trending Now", 17);
        add("🆕 New Releases", 17);
        add("🌎 Global Music", 17);
        add("⭐ Rising Artists", 17);

        Button player = button("▶  Open Music Player");
        content.addView(player);
        player.setOnClickListener(v -> showPlayer());
    }

    void showSearch() {
        base("Search");

        EditText search = new EditText(this);
        search.setHint("Search songs, artists, albums...");
        search.setTextColor(white);
        search.setHintTextColor(Color.GRAY);
        content.addView(search);

        Button b = button("🔍 Search");
        content.addView(b);

        add("Try searching for:", 18);
        add("Artists • Songs • Albums • Playlists • Genres", 15);
    }

    void showLibrary() {
        base("Your Library");

        add("❤️ Liked Songs", 18);
        add("🎵 Recently Played", 18);
        add("📁 Your Playlists", 18);
        add("⬇ Offline Music", 18);

        Button p = button("+ Create Playlist");
        content.addView(p);
    }

    void showParty() {
        base("Mine Mangoes Party");

        add("🎉 Create a shared music party", 20);
        add("Let friends join, add songs and vote.", 16);

        Button create = button("CREATE PARTY");
        content.addView(create);

        EditText code = new EditText(this);
        code.setHint("Enter Party Code");
        code.setTextColor(white);
        code.setHintTextColor(Color.GRAY);
        content.addView(code);

        Button join = button("JOIN PARTY");
        content.addView(join);
    }

    void showProfile() {
        base("Profile");

        add("👤 Mine Mangoes User", 20);
        add("Favorite Artists", 17);
        add("Favorite Genres", 17);
        add("Listening History", 17);
        add("Notifications", 17);
        add("Privacy & Settings", 17);

        Button theme = button("🌙 Dark / ☀ Light Theme");
        content.addView(theme);

        theme.setOnClickListener(v -> {
            if (root.getBackground() != null) {
                root.setBackgroundColor(Color.WHITE);
                title.setTextColor(Color.rgb(200,130,0));
            }
        });
    }

    void showPlayer() {
        base("Now Playing");

        add("🎵", 60);
        add("Mine Mangoes Demo Song", 22);
        add("Mine Mangoes Artist", 17);

        SeekBar seek = new SeekBar(this);
        content.addView(seek);

        LinearLayout controls = new LinearLayout(this);
        controls.setGravity(Gravity.CENTER);

        Button previous = button("⏮");
        Button play = button("▶");
        Button next = button("⏭");

        controls.addView(previous);
        controls.addView(play);
        controls.addView(next);

        content.addView(controls);

        add("♡ Like     + Playlist     ↗ Share", 16);
        add("Audio quality: Standard", 15);
    }

    void add(String value, int size) {
        TextView t = text(value, size);
        t.setBackgroundColor(card);
        t.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 6, 0, 6);
        content.addView(t, p);
    }
          }
