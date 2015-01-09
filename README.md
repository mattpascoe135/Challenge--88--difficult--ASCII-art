# Challenge--88--difficult--ASCII-art
Write a program that given an image file, produces an ASCII-art version of that image. 
Try it out on Snoo:
http://i.imgur.com/tJmB9.png

(note that the background is transparent, not white). There's no requirement that the ASCII-art be 
particularly good, it only needs to be good enough so that you recognize the original image in there.

Use:
ASCIIArt filename scale
  where filename is a string which leads to a image, JPG or PNG
  scale is a percentage between 0% - 200%

Example:
ASCIIArt testImage.jpg 80
  - displays the testImage in ASCII text at 80% the original file size
