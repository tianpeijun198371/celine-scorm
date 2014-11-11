/**
 * CELINE SCORM
 *
 * Copyright 2014 Adilson Vahldick.
 * https://celine-scorm.googlecode.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.univali.celine.scorm.model.imsss;

public class ConstrainedChoiceConsiderations {
	private boolean preventActivation;
	private boolean constrainChoice;
	
	public boolean isPreventActivation() {
		return preventActivation;
	}
	public void setPreventActivation(boolean preventActivation) {
		this.preventActivation = preventActivation;
	}
	public boolean isConstrainChoice() {
		return constrainChoice;
	}
	public void setConstrainChoice(boolean constrainChoice) {
		this.constrainChoice = constrainChoice;
	}
	
	@Override
	public String toString() {
		
		return String.format("<adlseq:constrainedChoiceConsiderations preventActivation=\"%s\" constrainChoice=\"%s\"/>\n",
								new Object[]{preventActivation, constrainChoice});
	}
	public void assign(
			ConstrainedChoiceConsiderations constrainedChoiceConsiderations) {
		// TODO Auto-generated method stub
		
	}
}
