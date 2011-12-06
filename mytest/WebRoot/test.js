
/*pub-2|2011-12-01 20:04:06*/
function Message() {
	this.send = function (a, b) {
		window.postMessage ? a.postMessage(b, "*") : a.name = b;
	};
}
var msg = new Message, crossFrame = {};
crossFrame.init = function (a) {
	a === undefined && (a = Math.max(document.body.offsetHeight, document.body.clientHeight, document.body.scrollHeight)), msg.send(window.top, a);
}, crossFrame.setHeight = function () {
	msg.send(window.top, Math.max(document.body.offsetHeight, document.body.clientHeight, document.body.scrollHeight));
};

