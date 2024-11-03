package org.algorithms.io.amazon2k24;


import java.util.*;

public class HotelReviews {
    public static void main(String[] args) {
        var hotelReview = new HotelReviews();
        System.out.println(
                hotelReview.solve(
                        "qghu_eay_nl_dxfi_cvsc_gg_wk_nqdu_wf_fozv_rtk_pr_p_g_rp_rvys_mwcy_y_c_pev_kef_mz_imkk_svw_r_nzk_cxf_tl_gyp_fad_oo_fxz_co_juv_vabo_gpo_ylf_bnpl_vrvi_ya_yeh_q_qrqp_x_j_loov_o_u_wh_s_cb_coks_zkva_xdkn_yj_h_ixjs_nkk_f_ux_zr_bmnm_q_oke_ly_nk_aug_qrcd_iute_ojw_yyz_vs_m_sa_lfvg_b_aaov_zy_nt_kdcp_s_te_j_hdi_co_zc_fw_qi_tv_wvxh",
                        new ArrayList(
                                List.of(

                                )
                        )
                )
        );
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        String[] arr = A.split("_");
        Trie root = new Trie();
        for (String word : arr) {
            root.insert(word);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> {
                    int c = e2.getValue().compareTo(e1.getValue());
                    return c == 0 ? e1.getKey().compareTo(e2.getKey()) : c;
                }
        );
        for (int i = 0; i < B.size(); i++) {
            String[] strArr = B.get(i).split("_");
            int count = 0;
            for (String s : strArr) {
                if (root.containsAll(s)) {
                    count++;
                }
            }
            maxHeap.offer(new AbstractMap.SimpleEntry<>(i, count));
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }

    static class Trie {
        private static final Integer MAX_LIMIT = 26;
        private final Trie[] branches;
        private int count;
        private boolean isComplete;

        public Trie() {
            this.branches = new Trie[MAX_LIMIT];
        }

        public void insert(String data) {
            Trie current = this;
            for (char c : data.toCharArray()) {
                int idx = c - 'a';
                if (current.branches[idx] == null) {
                    current.branches[idx] = new Trie();
                }
                current = current.branches[idx];
                current.count++;
            }
            current.isComplete = true;
        }

        public boolean containsAll(String data) {
            Trie current = this;
            for (char c : data.toCharArray()) {
                int idx = c - 'a';
                if (current.branches[idx] == null) {
                    return false;
                }
                current = current.branches[idx];
            }
            return current.isComplete;
        }

        public int matchingWordsCount(Trie root, String data) {
            Trie current = root;
            for (char c : data.toCharArray()) {
                int idx = c - 'a';
                if (current.branches[idx] == null) {
                    return 0;
                }
                current = current.branches[idx];
            }
            return current.count;
        }
    }
}

