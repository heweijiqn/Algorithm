/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 21:44
 */


package 字符串;
import java.util.*;
/*
描述
为了让牛牛和朋友们更好地沟通和共享信息，他们需要将一组单词按照一定的规则排列，以使得信息在每行的长度都一样，
并尽可能均匀地显示。他们希望你实现这个算法来帮助他们进行信息传递，需要遵守以下规则：
规则：
首先，按照顺序将单词尽可能多地放入每一行，直到该行的长度大于 maxWidth ，才能添加到下一行。
当某一行有超过一个单词时，单词间应有空格。尽量平均地分配空格，使得单词在这一行均匀排列。如果某一行的空格不能均匀分配，那么使行左侧的空格数多于右侧的空格数。
文本的最后一行应为左对齐，即行尾左侧不添加额外空格。
示例1
输入：
["Cows", "graze", "in", "pastures", "and", "drink", "water"],15
返回值：
["Cows  graze  in","pastures    and","drink water    "]

示例2
输入：
["Cows", "can", "jump", "over", "fences", "sometimes"],18
返回值：
["Cows can jump over","fences sometimes  "]

备注：
单词数组 words（1 <= words.length <= 300）
每个单词的长度（1 <= words[i].length <= 20）
每行字符数 maxWidth（1 <= maxWidth <= 100）
 */

public class 单词均匀排列 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param words string字符串一维数组
     * @param maxWidth int整型
     * @return string字符串一维数组
     */
    public String[] arrangeWords(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLine.isEmpty()) {
                currentLine.add(word);
                currentLength += word.length();
            } else {
                int requiredSpace = currentLine.size() + currentLength + word.length();
                if (requiredSpace <= maxWidth) {
                    currentLine.add(word);
                    currentLength += word.length();
                } else {
                    StringBuilder line = new StringBuilder();
                    if (currentLine.size() == 1) {
                        line.append(currentLine.get(0));
                        for (int i = currentLine.get(0).length(); i < maxWidth; i++) {
                            line.append(" ");
                        }
                    } else {
                        int totalSpace = maxWidth - currentLength;
                        int spaceBetweenWords = totalSpace / (currentLine.size() - 1);
                        int extraSpaces = totalSpace % (currentLine.size() - 1);

                        for (int i = 0; i < currentLine.size(); i++) {
                            line.append(currentLine.get(i));
                            if (i < currentLine.size() - 1) {
                                for (int j = 0; j < spaceBetweenWords; j++) {
                                    line.append(" ");
                                }
                                if (extraSpaces > 0) {
                                    line.append(" ");
                                    extraSpaces--;
                                }
                            }
                        }
                    }
                    result.add(line.toString());
                    currentLine.clear();
                    currentLine.add(word);
                    currentLength = word.length();
                }
            }
        }

        // Process the last line
        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < currentLine.size(); i++) {
            lastLine.append(currentLine.get(i));
            if (i < currentLine.size() - 1) {
                lastLine.append(" ");
            }
        }
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result.toArray(new String[0]);
    }
}
