# cafepandas
Miscellaneous data mining experiments with Java\
The goal is to duplicate some of the functionality found in the python libraries [pandas](https://pandas.pydata.org/) and [scikit-learn](https://scikit-learn.org/stable/index.html).

The first step is implementing [K-means clustering](https://en.wikipedia.org/wiki/K-means_clustering). At a very simple level, K-means attempts to group similar items, items in this case being multi dimensional coordinates, and similarity in this instance being determined by [Euclidean Distance](https://people.revoledu.com/kardi/tutorial/Similarity/EuclideanDistance.html "Euclidean Distance Explained") between the points.


![K-means process steps](public/images/WikiDiagram.PNG?raw=true "https://en.wikipedia.org/wiki/K-means_clustering")



[K-means in scikit learn](https://scikit-learn.org/stable/modules/generated/sklearn.cluster.KMeans.html, "sklearn.cluster.KMeans")

