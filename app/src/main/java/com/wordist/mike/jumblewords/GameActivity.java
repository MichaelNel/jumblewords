package com.wordist.mike.jumblewords;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class  GameActivity extends ActionBarActivity {

    StringBuilder player_word = new StringBuilder();
    StringBuilder found_words = new StringBuilder();
    GameResources words_hash = GameResources.getInstance();
    String words = words_hash.GameResources(1);
    int found_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle  extras  = getIntent().getExtras();
        String  letters = extras.getString("level_letters");
        String  letter;
        String  button_id;

        Button b_middle = (Button) findViewById(R.id.button_middle);
        b_middle.setText(Character.toString(letters.charAt(8)));

       for(int i = 0; i < 8; i++) {
           button_id = "button_" + Integer.toString(i);
           Button letter_button = (Button) findViewById(getResources()
                   .getIdentifier(button_id, "id", getPackageName()));
           try {
               letter = Character.toString(letters.charAt(i));
               letter_button.setText(letter);
           } catch (IndexOutOfBoundsException e) {
               letter_button.setVisibility(View.INVISIBLE);
           }
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void add_char(View view){
        Button pressed_button = (Button) view;
        pressed_button.setVisibility(View.INVISIBLE);
        TextView print_letters = (TextView) findViewById(R.id.print_string);
        TextView words_found = (TextView) findViewById(R.id.words_found);

        String pressed_letter = pressed_button.getText().toString();

        player_word.append(pressed_letter);

        String search_string = " " + player_word.toString().toLowerCase() + " ";
        // Search for player word in level words hash
        if (words.contains(search_string) && !found_words.toString().contains(search_string)) {
            found_words.append(search_string);
            // Show the word and add to the count
            found_count++;
            player_word.setLength(0);
            print_letters.setText("FOUND YAY!");
            reset_buttons();
        }else{
            print_letters.setText(player_word.toString());
        }
        words_found.setText(Integer.toString(found_count));
    }
    public void clear_player_string(View view){
        player_word.setLength(0);
        TextView print_letters = (TextView) findViewById(R.id.print_string);
        print_letters.setText("");
        reset_buttons();
    }


    public void reset_buttons(){
        Button b_middle = (Button) findViewById(R.id.button_middle);
        b_middle.setVisibility(View.VISIBLE);

        for(int i = 0; i < 8; i++){
            String view_name = "button_" + Integer.toString(i);
            Button button = (Button) findViewById(getResources().getIdentifier(view_name, "id", getPackageName()));
            button.setVisibility(View.VISIBLE);
        }
    }
}
