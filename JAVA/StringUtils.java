// In com.utils module:
// File: com/utils/StringUtils.java
package com.utils;

public class StringUtils {
    public static String shout(String text) {
        return text.toUpperCase() + "!";
    }
}

// File: module-info.java in com.utils
module com.utils {
    exports com.utils;
}

// In com.greetings module:
// File: com/greetings/Main.java
package com.greetings;

import com.utils.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.shout("hello"));
    }
}

// File: module-info.java in com.greetings
module com.greetings {
    requires com.utils;
}
