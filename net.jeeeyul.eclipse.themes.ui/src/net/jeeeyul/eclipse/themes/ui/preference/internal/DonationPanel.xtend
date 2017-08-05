package net.jeeeyul.eclipse.themes.ui.preference.internal

import net.jeeeyul.eclipse.themes.SharedImages
import net.jeeeyul.swtend.SWTExtensions
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.program.Program
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Link

class DonationPanel {
	extension SWTExtensions = SWTExtensions.INSTANCE
	Control control

	new(Composite parent) {
		control = parent.newComposite [
			
		]
	}

	def static void main(String[] args) {
		val extension SWTExtensions = SWTExtensions.INSTANCE
		newShell[
			layout = newGridLayout
			newPushButton[text = "a"]
			new DonationPanel(it) => [
				it.control.layoutData = FILL_HORIZONTAL
			]
			newPushButton[text = "b"]
		].openAndRunLoop
	}

}
