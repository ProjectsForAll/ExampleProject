package host.plas.exampleproject.utils;

import host.plas.exampleproject.ExampleProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageUtils {
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void logMessage(String message) {
        CommandSender sender = Bukkit.getConsoleSender();
        if (sender != null) {
            sender.sendMessage(colorize(message));
        } else {
            System.out.println(colorize(message));
        }
    }

    public static String getInfoLogPrefix() {
        return colorize("&7[&3" + ExampleProject.getInstance().getName() + "&7] &f");
    }

    public static String getErrorLogPrefix() {
        return colorize("&7[&3" + ExampleProject.getInstance().getName() + "&7] &c");
    }

    public static String getWarningLogPrefix() {
        return colorize("&7[&3" + ExampleProject.getInstance().getName() + "&7] &e");
    }

    public static String getDebugLogPrefix() {
        return colorize("&7[&3" + ExampleProject.getInstance().getName() + "&7] &7[&cDEBUG&7] &b");
    }

    public static void logInfo(String message) {
        logMessage(getInfoLogPrefix() + message);
    }

    public static void logError(String message) {
        logMessage(getErrorLogPrefix() + message);
    }

    public static void logWarning(String message) {
        logMessage(getWarningLogPrefix() + message);
    }

    public static void logDebug(String message) {
        logMessage(getDebugLogPrefix() + message);
    }

    public static void logInfo(Throwable throwable) {
        logInfo(throwable.getMessage());

        for (StackTraceElement element : throwable.getStackTrace()) {
            logInfo(element.toString());
        }

        if (throwable.getCause() != null) {
            logInfo(throwable.getCause());
        }
    }

    public static void logError(Throwable throwable) {
        logError(throwable.getMessage());

        for (StackTraceElement element : throwable.getStackTrace()) {
            logError(element.toString());
        }

        if (throwable.getCause() != null) {
            logError(throwable.getCause());
        }
    }

    public static void logWarning(Throwable throwable) {
        logWarning(throwable.getMessage());

        for (StackTraceElement element : throwable.getStackTrace()) {
            logWarning(element.toString());
        }

        if (throwable.getCause() != null) {
            logWarning(throwable.getCause());
        }
    }

    public static void logDebug(Throwable throwable) {
        logDebug(throwable.getMessage());

        for (StackTraceElement element : throwable.getStackTrace()) {
            logDebug(element.toString());
        }

        if (throwable.getCause() != null) {
            logDebug(throwable.getCause());
        }
    }
}
