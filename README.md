# Research into Android Canvas API based on: [Karpenko, Y. (2013). Android 2D Graphics with Canvas API.](http://www.amazon.com/Android-2D-Graphics-Canvas-API-ebook/dp/B00DKIAVK8)


**From The Book's Intro**

*Android SDK provides two powerful graphics libraries: OpenGL ES and Canvas API. This book is intended for programmers interested in learning Canvas API. Canvas API is an advanced two-dimensional graphics library. It provides methods for drawing text, lines, rectangles, circles and other graphics primitives.*

*In this book we will show how to use different graphics primitives, explain basics of coordinate systems and transformations, discuss two common approaches to writing multithreaded graphics applications, and provide a lot of examples.*

**About the talk**

During the talk, I gave a little demo and book review of the code from Karpenko's book. During my own study I worked each of the examples herein, a pattern -- working a book cover to cover -- that I have found useful in my own professional and intellectual development.  

I liked how the book walked, in a simple way, through 2D drawing primitives, and then gave some simple advanced hint at how the techniques could be combined with other working parts of an app.  However, the book really is about generating static drawings.  That's useful if what you want is to draw a picture from data without much interaction, but it's not so useful if you want to make some piece of a GUI.  Also, the book sort of touches on the threading needed to have a graphic respond to an in-progress event, but doesn't really go into it.

Fundamentally, if you have a familiarity with drawing primitives from some other framework... i.e. you know how to define a line, or what a stroke and fill are, then this book should be easy.  In that case use it as a syntax reference to get something built for android.  That's where my main criticism comes in....  On some level I already know that the API for a line takes into account start and end points, stroke width, color, and stippling pattern.  What I'd really like to know, and this book doesn't go into it, is how to not just have the machine draw a line, but have the user able to manipulate the graphic to create their own drawings, or to augment more traditional interfaces with graphics.

Still very worth reading and working through!  (Probably not worth reading unless you are actually going to do the exercises though!)

|||
:---:|:---|
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/arc.png) | ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/ball.png)
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/barchart.png) | ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/triangle-w-fill.png)
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/circle.png) | ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/circlechart.png)
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/custom_font.png)| ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/gradient.png)
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/oval.png) | ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/path.png)
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/screenSize.png) | ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/sweep-gradient.png)
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/text.png) | ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/text-alignment-horizontal.png)
![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/text-alignment-vertical.png) | ![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/text-baseline.png)

![](https://raw.githubusercontent.com/shalperin/android-canvas2D-talk-2016/master/screenshots/chart.png)

