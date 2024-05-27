/**
 * @author 何伟健
 * @version 1.0
 * @date 2024/5/20 22:00
 */


package 字符串;
import java.util.*;

/*
描述
在一个远离人类的世界中，有一群牛正在尝试识别危险路径。他们使用一个特殊的绝对路径序列，
以 '/' 分隔各区域。每个区域的名称是由字母、数字、'.'、'/' 或 '_'组成。这些区域之间可能有危险，所以牛们想要找到一种方式将这些路径简化并有效地表示。
牛群使用一种特殊的路径简化规则：

一个点（.）表示当前目录本身。
两个点（..）表示将区域切换到上一级（指向父区域）。
其他格式的点（例如，'...'）均被视为区域名称。
需要注意的是，简化后的路径必须满足以下要求：

始终以斜杠 '/' 开头。
两个区域名之间必须只有一个斜杠 '/'。
最后一个区域名（如果存在）不能以 '/' 结尾。
路径仅包含从根目录到目标文件或目录的路径上的实际区域（即，不包含 '.' 或 '..'）。
编写一个函数，给定一个绝对路径字符串 path，返回该危险路径的简化规范表示。

示例1
输入："/green/lake/"
返回值："/green/lake"

示例2
输入："/../"
返回值："/"

示例3
输入："/place/./region/../../mountain/"
返回值："/mountain"
复制
备注：
1<= path.length <= 3000，由英文字母，数字，'.'，'/' 或 '_' 组成。
 */

public class 切割 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param path string字符串
     * @return string字符串
     */
    public String find_dangerous_cow_path (String path) {
        // 使用栈来模拟路径简化操作
        Deque<String> stack = new ArrayDeque<>();

        // 将路径按照 '/' 分割
        String[] areas = path.split("/");

        // 遍历路径中的每个区域
        for (String area : areas) {
            // 如果遇到点（'.'），则跳过
            if (area.equals(".") || area.isEmpty()) {
                continue;
            }
            // 如果遇到两个点（'..'），则将栈顶元素出栈
            else if (area.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // 否则将当前区域名入栈
            else {
                stack.push(area);
            }
        }

        // 如果栈为空，表示路径为根路径
        if (stack.isEmpty()) {
            return "/";
        }

        // 将栈中的元素按照规范形式拼接起来
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        // 返回简化后的路径
        return sb.toString();
    }
}
