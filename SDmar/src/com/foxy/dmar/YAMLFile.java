package com.foxy.dmar;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class YAMLFile {
  private File YAML_FILE;
  
  private FileConfiguration YAML;
  
  private HashMap<String, String> messages = new HashMap<>();
  
  private HashMap<String, Object> objects = new HashMap<>();
  
  public YAMLFile(String path, String file) {
    this.YAML_FILE = new File(path, file);
    this.YAML = (FileConfiguration)YamlConfiguration.loadConfiguration(this.YAML_FILE);
  }
  
  public void save() {
    try {
      this.YAML.save(this.YAML_FILE);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public FileConfiguration getYAML() {
    return this.YAML;
  }
  
  public Object getOrAddDefault(String path, Object value) {
    if (this.objects.containsKey(path))
      return this.objects.get(path); 
    if (this.YAML.isSet(path)) {
      Object get = this.YAML.get(path);
      this.objects.put(path, get);
      save();
      return get;
    } 
    this.YAML.set(path, value);
    this.objects.put(path, value);
    save();
    return value;
  }
  
  public String getOrAddDefault(String path, String value) {
    if (this.messages.containsKey(path))
      return this.messages.get(path); 
    if (this.YAML.isSet(path)) {
      String get = this.YAML.getString(path);
      this.messages.put(path, get);
      save();
      return get;
    } 
    this.YAML.set(path, value);
    this.messages.put(path, value);
    save();
    return value;
  }
  
  public String getString(String path) {
    if (this.messages.containsKey(path))
      return this.messages.get(path); 
    if (this.YAML.isSet(path)) {
      String get = this.YAML.getString(path);
      this.messages.put(path, get);
      save();
      return get;
    } 
    System.out.println("WARN: File not found!");
    return null;
  }
}
