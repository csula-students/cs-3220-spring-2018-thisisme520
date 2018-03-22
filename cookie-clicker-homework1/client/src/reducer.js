import constants from './constants.js';
import Generator from './models/generator';
import Story from './models/story';
export default function reducer (state, action) {
	switch (action.type) {
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;
		case constants.actions.INCREMENT:
		state.counter += action.payload;
		return state;

	case constants.actions.BUY_GENERATOR:
		state.generators.forEach(generator => {
			if(generator.name === action.payload.name){
				let gen = new Generator(generator);
				let generatorCost = gen.getCost(); 
				if(generatorCost <= state.counter){ 
					state.counter -= generatorCost; 
					generator.quantity++;
					generator.unlockValue = gen.getCost(); 
				}
			}
		});
		return state;

	case constants.actions.CHECK_STORY:

		state.stories.forEach(story => {
			let sto = new Story(story);
			if(sto.isUnlockYet(state.counter)){
				sto.unlock();
				story.state = sto.state;

			}
		});
		return state;

	default:
		return state;
	}
}


