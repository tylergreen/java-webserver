def jcompile(file)
    system "javac -classpath .:junit-4.11-SNAPSHOT-20120416-1530.jar #{file}"
end

task :test do
  system "java -classpath .:junit-4.11-SNAPSHOT-20120416-1530.jar com.webserver.MyTestRunner"
end

task :compile_tester do
  jcompile "com/webserver/MyTestRunner.java"
end

task :compile do
  %w(Webserver Dispatcher FileServer).each do |file|
    jcompile "com/webserver/#{file}.java"
    jcompile "com/webserver/#{file}Test.java"
  end
end

task :default => [:compile, :test]

		
