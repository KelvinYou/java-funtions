package com.mycompany.java.functions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class EscapePassword {
    public static void main(String[] args) {
        String input = "Demo&1234";
        String escapedHtml = escapeHtml(input);
        System.out.println(escapedHtml);
    }
    
    public static String escapeHtml(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&#39;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static String reverseEscapeHtml(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (c == '&') {
                if (i + 4 < input.length() && input.substring(i, i + 5).equals("&amp;")) {
                    sb.append('&');
                    i += 5;
                } else if (i + 3 < input.length() && input.substring(i, i + 4).equals("&lt;")) {
                    sb.append('<');
                    i += 4;
                } else if (i + 3 < input.length() && input.substring(i, i + 4).equals("&gt;")) {
                    sb.append('>');
                    i += 4;
                } else if (i + 5 < input.length() && input.substring(i, i + 6).equals("&quot;")) {
                    sb.append('"');
                    i += 6;
                } else {
                    sb.append(c);
                    i++;
                }
            } else if (c == '\'') {
                sb.append('\'');
                i++;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}


