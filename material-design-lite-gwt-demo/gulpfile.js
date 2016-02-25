//importing gulp to manage the frontend build workflow
var gulp = require('gulp');

// use the swig template engine to manage html content
// the gulp-swig package is used to integrate swig with gulp
// workflow
var swig = require('gulp-swig');

// read cli parameters using minimist
var minimist = require('minimist');

// setting up the default values for unspecified cli parameters
// if src is not provided assume that src/main/webapp
// is root of the frontend content
var opts = {
	'default' : {
		'src' : 'src/main/webapp',
	}
};

// read the cli parameters starting from the third parameter
// the first one is the path to node
// the second one is to gulp
var argv = minimist(process.argv.slice(2), opts);

// in argv will be stored the read values of src and dest
var src_dir = argv.src;

var dest_dir = argv.dest;

// unlike the src parameter for which a default value is provided
// it is not guarantee that the dest parameter is defined
// if dest is not defined exit with error
if (dest_dir === undefined) {
	console.log("The destination folder parameter is not optional !");
	console.log("Please provide a value for the dest parameter");
	console.log("--dest=path/to/dist");
	process.exit(1);
}

// setup the paths
// setup a matcher to all resources
var all = src_dir + '/**';
// setup a matcher to html resources
var htmls = src_dir + '/**/*.html';
// setup a matcher to all resources except html
var not_htmls = '!' + htmls;

// defining the default task
gulp.task('default', function() {
	// match all resource except html
	// it mandatory to specify a positive match in order to
	// use a negative matcher, in this case the positive matcher
	// matches all resources
	gulp.src([ all, not_htmls ])

	// put all the matched resources in the dest folder
	.pipe(gulp.dest(dest_dir));

	// match all html files
	gulp.src(htmls)
	
	//apply the template engine 
	.pipe(swig())
	
	// put the resulting files in the dest folder
	.pipe(gulp.dest(dest_dir));
});
