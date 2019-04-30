package com.dsl.algorithms.pattern.match;

import org.apache.commons.lang3.StringUtils;

/**
 * 模式匹配算法-1
 * 暴露匹配算法
 * <p>
 * O[(n-m)m]
 * 基本思想：从主串的第start个字符开始起，和模式中的第一个字符比较，如果相对则继续逐个比较后续字符，
 * 如果不相等,则回溯到主串的start+1字符位置处
 * <p>
 * 优点：简单、直观
 * 缺点：由于没有记录历史比较信息，导致需要不断的回溯，因此算法效率差
 */
public class BF {
    public static void main(String[] args) {
        System.out.println(bf("aaaaaaaaduanshuliang","dauan"));
    }

    private static boolean bf(String t, String p) {
        if (StringUtils.isBlank(t) || StringUtils.isBlank(p)) {
            return false;
        }

        boolean matched = false;
        char[] tChars = t.toCharArray();
        char[] pChars = p.toCharArray();
        int tCharLen = tChars.length;
        int pCharsLen = pChars.length;

        for (int i = 0; i < tCharLen - pCharsLen; i++) {
            boolean flag = true;
            for (int j = 0; j < pCharsLen; j++) {
                if(pChars[j]!=tChars[j+i]){//如果在此没有匹配成功，回溯至tChars的j+1位置
                    flag = false;
                    break;
                }
            }
            if(flag){
                matched = true;
                break;
            }
        }
        return matched;
    }
}
