package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("携帯電話番号を入力してください(ハイフンを入れて): ");
      String phoneNumber = scanner.nextLine();

      if (validatePhoneNumber(phoneNumber)) {
        System.out.println(phoneNumber + " は有効な携帯電話番号です。");
        break; // 有効な番号ならループを抜ける
      }
    }
    scanner.close();
  }

  public static boolean validatePhoneNumber(String phoneNumber) {

    // 入力が空の場合のチェック
    if (phoneNumber.isEmpty()) {
      System.out.println("エラー：携帯電話番号を入力してください。");
      return false;
    }

    // 全体的な形式チェック。数字以外の文字や不正な桁数が含まれていないかどうかの確認も含む
    //「3桁の数字 + ハイフン + 4桁の数字 + ハイフン + 4桁の数字」の形式に一致する文字列を検索
    if (!phoneNumber.matches("^\\d{3}-\\d{4}-\\d{4}$")) {
      System.out.println("エラー：ハイフンを入れて、正しい形式（xxx-xxxx-xxxx）で入力してください。");
      return false;
    }

    // 先頭3桁のチェック
    //「070、080、090のいずれかの数字 + ハイフン + 4桁の数字 + ハイフン + 4桁の数字」の形式に一致する文字列を検索
    if (!phoneNumber.matches("^(070|080|090)-\\d{4}-\\d{4}$")) {
      System.out.println("エラー：070、080、090のいずれかで始まる番号を入力してください。");
      return false;
    }

    // すべての条件を満たしている場合
    return true;
  }
}
