package com.dsl.algorithms;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 模式匹配算法-2  MP
 * 充分利用了模式中字符之间的关系避免像BF算法不断地回溯过程
 *
 */
public class MP {
    private static int[] unmatchPositions;

    private static void failureFunction(String pattern) {
        if (StringUtils.isBlank(pattern)) {
            return;
        }

        int len = pattern.length();
        unmatchPositions = new int[len + 1];

        int i = 0;
        int j = unmatchPositions[0] = -1;
        while (i < len) {
            while (j > -1 && pattern.charAt(i) != pattern.charAt(j)) {
                j = unmatchPositions[j];
            }
            unmatchPositions[++i] = ++j;

        }

    }

    /**
     * 模式匹配
     *
     * @param term
     * @param pattern
     * @return
     */
    private static boolean hasPattern(String term, String pattern) {
        if (StringUtils.isBlank(pattern) || StringUtils.isBlank(term) || pattern.length() > term.length()) {
            return false;
        }

        boolean flag = false;
        int m = pattern.length();
        int n = term.length();

        int i = 0;
        int j = 0;
        failureFunction(pattern);

        while (j < n) {
            while (i > -1 && pattern.charAt(i) != term.charAt(j)) {
                i = unmatchPositions[i];
            }
            i++;
            j++;
            if (i >= m) {
                System.out.println("match index " + (j - i));
                i = unmatchPositions[i];
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 找出所有的匹配地址
     *
     * @param term
     * @param pattern
     * @return
     */
    private static List<Integer> findAllMatchIndex(String term, String pattern){
        if (StringUtils.isBlank(pattern) || StringUtils.isBlank(term) || pattern.length() > term.length()) {
            return null;
        }

        List<Integer> indics = new ArrayList<Integer>();
        int m = pattern.length();
        int n = term.length();

        int i = 0;
        int j = 0;
        failureFunction(pattern);

        while (j < n) {
            while (i > -1 && pattern.charAt(i) != term.charAt(j)) {
                i = unmatchPositions[i];
            }
            i++;
            j++;
            if (i >= m) {
                indics.add(j - i);
                i = unmatchPositions[i];
            }
        }

        return indics;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(findAllMatchIndex("dasouche", "souc")));
        System.out.println(JSON.toJSONString(unmatchPositions));
    }
}
