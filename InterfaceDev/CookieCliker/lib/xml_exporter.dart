import 'dart:convert';
import 'dart:io';
import 'package:external_path/external_path.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class XmlExporter {
  Future<String> get _localPath async {
    return await ExternalPath.getExternalStoragePublicDirectory(
        ExternalPath.DIRECTORY_DOWNLOADS);
  }

  Future<File> get localFile async {
    final path = await _localPath;
    return File('$path/cookiecliker.json');
  }

  Future<bool> save(BuildContext context, Map<String, int> data) async {
    try {
      File file = await localFile;
      if (await file.exists()) file.delete();

      file.create();
      file.writeAsString(jsonEncode(data));
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
        content: Text("Archivo guardado en: " + (await localFile).toString()),
      ));
    } catch (e) {
      return true;
    }
    return false;
  }
}
