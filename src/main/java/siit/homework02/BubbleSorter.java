package siit.homework02;

/**
 * Implement a bubble sort algorithm.
 */
public class BubbleSorter {
    /**
     * Implement a bubble sort algorithm ascending or descending.
     *
     * @param salesRepresentatives an array of {@link SalesRepresentative}.
     * @param sortAscending        true to sort ascending, false to sort descending.
     */
    public void sort(SalesRepresentative[] salesRepresentatives, boolean sortAscending) {
        for (int i = 0; i < salesRepresentatives.length; i++) {
            for (int k = 0; k < salesRepresentatives.length - 1; k++) {
                if (sortAscending) {
                    if (salesRepresentatives[k].getRevenue() > salesRepresentatives[k + 1].getRevenue()) {
                        SalesRepresentative pahar = salesRepresentatives[k];
                        salesRepresentatives[k] = salesRepresentatives[k + 1];
                        salesRepresentatives[k + 1] = pahar;
                    }
                } else {
                    if (salesRepresentatives[k].getRevenue() < salesRepresentatives[k + 1].getRevenue()) {
                        SalesRepresentative pahar = salesRepresentatives[k];
                        salesRepresentatives[k] = salesRepresentatives[k + 1];
                        salesRepresentatives[k + 1] = pahar;
                    }
                }
            }
        }
    }
}
