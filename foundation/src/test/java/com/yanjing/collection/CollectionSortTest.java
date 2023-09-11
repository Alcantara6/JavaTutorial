package com.yanjing.collection;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanjing
 * @date 2023/5/7
 */
public class CollectionSortTest {

    /**
     * LinkedList指定索引add
     * Collections.sort
     * 泛型类成员要实现Comparable
     * 静态内部类
     */

    private List<Song> createSongs() {
        List<Song> songs = new LinkedList<>();
        songs.add(new Song("zhangsan", "a"));
        songs.add(new Song("lisi", "b"));
        songs.add(1, new Song("lisi", "c"));
        return songs;
    }

    // 按artist排序
    @Test
    public void sort_comparable() {
        List<Song> songs = createSongs();
        Collections.sort(songs);
        System.out.println("按artist排序" + songs);
    }

    // 按title排序
    // 有了comparator, comparable无效了
    @Test
    public void sort_comparator_to() {
        List<Song> songs = createSongs();
        Collections.sort(songs, (Song curr, Song another) -> {
            return curr.title == null ? 1 : another.title == null ? -1 : curr.title.compareTo(another.title);
        });
        System.out.println("按title排序" + songs);
    }

    // 按artist、title排序
    // 有了comparator, comparable无效了
    @Test
    public void sort_comparator_comparing() {
        List<Song> songs = createSongs();
        Collections.sort(songs, Comparator.comparing(Song::getArtist).thenComparing(Song::getTitle));
        System.out.println("按artist、title排序" + songs);
    }


    static class Song implements Comparable<Song> {
        private String artist;
        private String title;

        public Song(String artist, String title) {
            this.artist = artist;
            this.title = title;
        }

        public String getArtist() {
            return artist;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public int compareTo(Song o) {
            return this.artist == null ? 1 : o.artist == null ? -1 : this.artist.compareTo(o.artist);
        }

        @Override
        public String toString() {
            return artist + ": " + title;
        }
    }
}
