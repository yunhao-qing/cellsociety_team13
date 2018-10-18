Haotian
>@Julia Saveliff why does getBndle automatically recognizes the file path is relative to src/ instead of the project folder or the package folder or resources root?
thank you btw for this amazing organizing!

Julia
>I’m not sure why that is the default but I think the way it is built is to look in src
Maybe properties files are typically organized in src?

Haotian
>https://docs.oracle.com/javase/7/docs/api/java/util/ResourceBundle.html I think by default it's the classloader locale
if you specify it however in resources root
then it's different
https://docs.oracle.com/javase/8/docs/technotes/guides/lang/resources.html and this is a nice doc
