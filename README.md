# Bad Apple in java
This is a fork of the Bad Apple demo for TI-84. This code uses the video binary file to print it on the console.

## Building

### Video
The source video is contained in `./video/frames.bin.gz`. It simply stores each pixel in one byte, 0 or 1, with a scan order of left to right, then top to bottom, then first frame to last frame, and finally, the entire file is gzipped. Frames are 96x64 pixels. To make sure the video gets reencoded, delete `./bin/videopages.bin` if it already exists.

### Audio
Edit Ch1 - Ch4 of `./music/badapple.mmp` with [LMMS](https://lmms.io/). You shouldn't change the channel names or synths. Notes within a channel should not overlap, and note lengths should be multiples of 1/32 notes. To change the tempo of the music, change the value of `musicInterval` in `./badapple.asm`. When building, the file will be automatically read and converted.

`./music/original` contains the original files provided by the 4chan user who created the chiptune arrangement used in this demo, created using Cubase and Reason. However, they are not directly used.
