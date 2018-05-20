export function formatSecondsToMinutes(seconds) {
	// TODO: format seconds to minutes:seconds format
	// e.g. `65` seconds should become `01:05`
	// e.g. `5` seconds should become `00:05`
	return '';
}

// utility function to send post request to server to increment pomodoro counter
export function incrementPomodoroCounter (id, callback) {
	console.log('sending post request to increment pomodoro counter');
	fetch(`pomodoro?id=${id}`, {
		method: 'POST'
	})
	.then(callback)
	.catch(console.log);
}
