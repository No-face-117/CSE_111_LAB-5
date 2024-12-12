// CSE-111 LAB - 5 TASK - 1,2,3,4,5,6,7,8,9,10,11     []
// Topic-that-shall-not-be-named 🪄

class Song {   // Task - 1
    public String name = "Topic-that-shall-not-be-named!";
    public String auther = "IDK =-+-= SOMEBODY";
    public int length = 0;

    Song nexts;

    public Song(String nks_0, String art_nk_0, int lnk_0) {   // Task - 1
        this.name = nks_0;
        this.auther = art_nk_0;
        this.length = lnk_0;
        this.nexts = null;

    }

    public void songInfo() {   // Task - 1
        System.out.println("Title: " + name);
        System.out.println("auther: " + auther);
        System.out.println("Length: " + length + " minutes");

    }
}

class Playlist {   // Task - 2
    String name;
    Song son_start;
    String play_history;

    public Playlist(String nkp_0) {   // Task - 2
        this.name = nkp_0;
        this.son_start = null;
        this.play_history = "";

        System.out.println(nkp_0 + " created.");

    }

    public void addSong(Song snk_0) {   // Task - 3&4
        if (son_start == null) {
            son_start = snk_0;
        } 
        else {
            Song temp_s_0 = son_start;

            while (temp_s_0.nexts != null) {
                temp_s_0 = temp_s_0.nexts;
            }

            temp_s_0.nexts = snk_0;
        }

        System.out.println(snk_0.name + " added to " + name + ".");
    }

    public void addSong(Song snk_1, int indx_0) {   // Task - 5
        if (indx_0 < 0) {
            System.out.println("Cannot add song to Index : " + indx_0 + "!.");
        }
        else{}

        if (indx_0 == 0 || son_start == null) {
            snk_1.nexts = son_start;
            son_start = snk_1;

        } 
        else {
            Song temp_s_1 = son_start;

            for (int i = 1; i < indx_0 && temp_s_1.nexts != null; i++) {
                temp_s_1 = temp_s_1.nexts;
            }

            if (temp_s_1 == null) {
                System.out.println("Cannot add song to Index : " + indx_0 + "!.");
            }
            else{
                snk_1.nexts = temp_s_1.nexts;
                temp_s_1.nexts = snk_1;
            }
            
        }
        System.out.println(snk_1.name + " added to " + this.name + ".");
    }

    public void playSong(String nks_1) {   // Task - 6
        Song temp_s_3 = son_start;

        while (temp_s_3 != null) {
            if (temp_s_3.name.equals(nks_1)) {
                System.out.println("Playing : " + nks_1 + " ,by " + temp_s_3.auther + ".");

                play_history += "Title : " + temp_s_3.name + "\n";
                break;
            }
            else{
                temp_s_3 = temp_s_3.nexts;
            }
            
        }
        System.out.println(nks_1 + " not found in playlist : " + this.name + "!.");
    }

    public void playSong(int indx_1) {   // Task - 7
        Song temp_s_4 = son_start;

        for (int i = 0; i < indx_1 && temp_s_4 != null; i++) {
            temp_s_4 = temp_s_4.nexts;
        }

        if (temp_s_4 != null) {
            System.out.println("Playing : " + temp_s_4.name + " ,by " + temp_s_4.auther + ".");
            play_history += "Title : " + temp_s_4.name + "\n";
        } 
        else {
            System.out.println("Song at Index " + indx_1 + " not found in " + this.name + "!.");
        }
    }

    public void deleteSong(String nks_0) {   // Task - 8
        if (son_start == null) {
            System.out.println("Playlist is empty!.");
        }
        else{}

        if (son_start.name.equals(nks_0)) {
            son_start = son_start.nexts;
            System.out.println(nks_0 + " deleted from " + this.name + "!.");
        }
        else{}

        Song temp_s_2 = son_start;

        while (temp_s_2.nexts != null && !temp_s_2.nexts.name.equals(nks_0)) {
            temp_s_2 = temp_s_2.nexts;
        }

        if (temp_s_2.nexts != null) {
            temp_s_2.nexts = temp_s_2.nexts.nexts;
            System.out.println(nks_0 + " deleted from " + this.name + ".");
        } 
        else {
            System.out.println(nks_0 + " not found in playlist : " + this.name + "!.");
        }
    }

    public void info() {   // Task - 3&4
        System.out.println(this.name + " has the following songs : ");
        System.out.println();

        if (son_start == null) {
            System.out.println("No songs in " + this.name + "!.");
        }
        else{}

        int index = 1;
        Song temp_s_5 = son_start;
        
        while (temp_s_5 != null) {
            System.out.println("Song - " + index);
            temp_s_5.songInfo();
            temp_s_5 = temp_s_5.nexts;
            index++;

            System.out.println();
        }
    }

    public int totalSong() {   // Task - 9
        int count = 0;
        Song temp_s_6 = son_start;

        while (temp_s_6 != null) {
            count++;
            temp_s_6 = temp_s_6.nexts;
        }
        return count;
    }

    public void merge(Playlist another_p) {   // Task - 10
        if (son_start == null) {
            son_start = another_p.son_start;
        } 
        else {
            Song temp_s_7 = son_start;
            while (temp_s_7.nexts != null) {
                temp_s_7 = temp_s_7.nexts;
            }
            temp_s_7.nexts = another_p.son_start;
        }
        another_p.son_start = null;
        System.out.println("Merge Completed!");
    }

    public void showHistory() {   // Task - 11 [UG - OP]
        System.out.println("History of " + name + " : ");

        if (play_history.equals("")) {
            System.out.println("No songs were played from " + name + "!.");
        } 
        else {
            System.out.println(play_history);
        }
    }
}
