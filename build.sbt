name := "sandbox"


resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "commons-codec"                 %  "commons-codec"        % "1.9",
  "commons-io"                    %  "commons-io"           % "2.4",
  "joda-time"                     %  "joda-time"            % "2.3",
  "org.joda"                      %  "joda-convert"         % "1.3.1",
  "com.google.code.findbugs"      %  "jsr305"               % "2.0.0", // this is needed to keep scalac from puking due to https://issues.scala-lang.org/browse/SI-7751
  "org.typelevel"                 %% "scodec-core"          % "1.3.0",
  "io.argonaut"                   %% "argonaut"             % "6.1-M4",
  "net.databinder.dispatch"       %% "dispatch-core"        % "0.11.1",
  "org.scalaz"                    %% "scalaz-core"          % "7.1.0",
  "org.scalaz.stream"             %% "scalaz-stream"        % "0.6"
)

initialCommands in console := "import scalaz.Scalaz._"
