package org.zerowarning.gwt.mdl.demo.navigation;

import java.lang.reflect.Array;

import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.regexp.shared.SplitResult;

/**
 * 
 * Utility class, combining a set of useful and recurring behaviors related to
 * urls handling.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class UrlManager {

	/**
	 * Splits an url into a array of fragments delimited by slashes
	 * <code>"/"</code>.<br>
	 * <br>
	 * Example :<br>
	 * <b>input</b><i>"link//to/page.html"</i><br>
	 * <br>
	 * <b>output</b><i>String[]{"link", "to", "page.html"}</i>
	 * 
	 * @param url
	 *            the input url.
	 * 
	 * @param leaf
	 *            <code>true</code> to include the last part of the url (the
	 *            page), <code>false</code> otherwise.
	 * 
	 * @return An {@link Array} of {@link String} containing the url parts.
	 */
	public String[] splitUrl(String url, boolean leaf) {

		// split the url into parts separated by slashes
		SplitResult result = pattern.split(url);

		// remove the last fragment as it contains either an empty string or a
		// page name.
		int count;

		// if leaf is true include the last part in the returned array
		count = result.length() - (leaf ? 0 : 1);

		// setup the array of strings
		String[] splits = new String[count];

		// copy each part into the string's array.
		for (int i = 0; i < count; i++) {

			// put the ith element in the ith case of the array.
			splits[i] = result.get(i);
		}

		// return the array parts.
		return splits;
	}

	/**
	 * 
	 * When dealing with relative urls, it is sometimes useful to rewrite a url
	 * according to another url. To do so, it is required to step back from the
	 * current location to a common parent located n step out. Stepping back n
	 * times is aquivalent to adding "../" n times to the input url.
	 * 
	 * @param count
	 *            step back n times
	 * @param url
	 *            the relative url to be rewritten.
	 * @return the resulting url expressed from the location of the common
	 *         parent.
	 */
	public String stepBack(int count, String url) {

		// first setup the string appender
		StringBuilder sb = new StringBuilder();

		// then add as much "../" as indicated by the count variable
		for (int i = 0; i < count; i++) {
			sb.append("../");
		}

		// finally, add the input url
		sb.append(url);

		// return the resulting string
		return sb.toString();
	}

	/**
	 * Challenge a url against another url to determine whether the former
	 * contains the latter. If the urls are completely included one into the
	 * other, then return the index of the first part where the inclusion is
	 * detected on the including url.
	 * 
	 * @param including
	 *            the url that should contain the included url.
	 * 
	 * @param included
	 *            the url that should be contained in the including url.
	 * 
	 * @return if the first url completely includes the second url return the
	 *         index of the first part of the including url where the included
	 *         url appears.
	 */
	public int urlInclusion(String[] including, String[] included) {

		// if the longer url is undefined quit
		if (including == null) {
			return -1;
		}

		int dingSize = including.length;

		// if the longer url is empty quit
		if (dingSize == 0) {
			return -1;
		}

		// if the shorter url is undefined quit
		if (included == null) {
			return -1;
		}

		int dedSize = included.length;

		// if the shorter url is empty quit
		if (dedSize == 0) {
			return -1;
		}

		// if the supposedly longer url is in fact shorter than the other url
		// then quit
		if (dingSize < dedSize) {

		}

		int startDingIdx = -1;
		int startDedIdx = 0;
		String firstDed = included[startDedIdx];

		// in the longer url look for the part that is identical to the first
		// part of the short url.
		for (int i = dingSize - 1; i >= 0; i--) {

			// if a match is found store the index of the matching part in the
			// longer url.
			if (including[i].equalsIgnoreCase(firstDed)) {
				startDingIdx = i;
			}
		}

		// the longer url was scanned entirely without finding the first part of
		// the short url in it. The short url can never be entirely included in
		// the longer url.
		if (startDingIdx == -1) {
			return -1;
		}

		// the last match positions are startDingIdx in the longer url and 1 in
		// the shorter url. pick up the matching from these last positions.

		// the matching start form the part that follows the previous match
		// position in the longer url.
		int nextDingIdx = startDingIdx + 1;

		// the matching starts from the second position in the shorter url.
		int nextDedIdx = 1;

		// how many parts are left in the longer url.
		int dingTogo = dingSize - nextDingIdx;

		// how many parts are left in the shorter url.
		int shortTogo = dedSize - nextDedIdx;

		// if there are more part lefts in the shorter url then abort
		if (dingTogo < shortTogo) {
			return -1;
		}

		// the match must be stopped when it reaches the end of the shorter url.
		int distanceToGo = shortTogo;
		String currLong;
		String currShort;

		// all the remaining part of the shorter url must be included in the
		// longer url. If not the shorter url is not entirely included in the
		// longer url.
		for (int i = 0; i < distanceToGo; i++, nextDedIdx++, nextDingIdx++) {
			currLong = including[nextDingIdx];
			currShort = included[nextDedIdx];

			// the shorter url is not completely included in the longer url.
			if (!currLong.equalsIgnoreCase(currShort)) {
				return -1;
			}
		}

		// return the index of the first match in the longer url implicitly
		// indicating that the shorter url is completely included in the longer
		// one. Otherwise, if the shorter url is not completely included in the
		// longer url, there is no point of returning the first match position,
		// and in this situation send -1 to indicate that the match failed.
		return startDingIdx;
	}

	// setup the regular expression to match the slashes
	private RegExp pattern = RegExp.compile("/+");
}
