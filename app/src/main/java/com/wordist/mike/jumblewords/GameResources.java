package com.wordist.mike.jumblewords;

import java.util.HashMap;

/**
 * Created by mike on 15/07/15.
 */
public class GameResources {
    private static GameResources ourInstance = new GameResources();

    public static GameResources getInstance() {
        return ourInstance;
    }

    public String GameResources(int i) {
        HashMap<Integer , String> words = new HashMap<Integer, String>();
        words.put(1, "ainu anus arius aunt aunts austin auto autos insular insulator insult laius " +
                "lauri linus lotus louis louisa lout louts luis luisa luna lunar luria lust nous " +
                "nutria nutrias nuts onus ours oust outran outs raoul raul ritual rituals rout " +
                "routs ruin ruins runs runt runts rust rutan ruts saturn saul slur slut snout soul " +
                "sour stun suit suitor sultan sunlit surat torus tour tours tulsa tuna tunas tunis " +
                "tuns turin turn turns ulna ulnas ultra ultras unit unitas units until unto ural " +
                "urals urinal urinals uris urns ursa insulator\n ");

        String level_words = words.get(i);
        return level_words;
    }
}
