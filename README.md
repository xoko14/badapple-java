# Bad Apple in java
This is a fork of the Bad Apple demo for TI-84. This code uses the video binary file from the original repository to print the 3:40 minute video on the console.

## Editing

### Video
The source video is contained in `./src/main/java/com/frames.bin.gz`. It simply stores each pixel in one byte, 0 or 1, with a scan order of left to right, then top to bottom, then first frame to last frame, and finally, the entire file is gzipped. Frames are 96x64 pixels. To make sure the video gets reencoded, delete `./bin/videopages.bin` if it already exists.

### Audio
The audio is the original version of the song, located in `./src/main/java/com/frames.bin.gz`.
