package lambda_expressions.chapter3;

import lambda_expressions.chapter1.Artist;

import java.util.Iterator;
import java.util.List;

/**
 * Project: java8-lambdas
 * FileName: Iteration
 * Date: 2016-07-22
 * Time: 오전 8:37
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class Iteration {
    public int externalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN external_count_londoners
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners
        return count;
    }

    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists) {
        // BEGIN external_count_londoners_expanded
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners_expanded
        return count;
    }


    public long internalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN internal_count_londoners
        long count = allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
        // END internal_count_londoners
        return count;
    }

    public void filterArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN filter_londoners
        allArtists.stream()
                .filter(artist -> artist.isFrom("London"));
        // END filter_londoners
    }

    public void filterArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN filter_londoners_printed
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });
        // END filter_londoners_printed
    }

    public long internalCountArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN internal_count_londoners_printed
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();
        // END internal_count_londoners_printed
        return count;
    }

}
